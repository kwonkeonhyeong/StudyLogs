const fs = require('fs');
const path = require('path');

// 훅 실행 로깅 (항상 출력)
console.error('🚀 디스패처 실행됨!');

const input = fs.readFileSync(0, 'utf8');
try {
    // Claude가 stdin을 통해 전달한 JSON 데이터를 읽습니다.
    const data = JSON.parse(input);

    const toolName = data.tool_name;
    // 파일 경로는 tool_input 객체 안에 다양한 형태로 존재할 수 있어, 순차적으로 확인합니다.
    const rawFilePath = data.tool_input.path ||
        data.tool_input.file_path ||
        (data.tool_input.args && data.tool_input.args[0]) || '';

    // 핵심: 경로 구분자를 슬래시로 통일
    const filePath = rawFilePath.split(path.sep).join('/');
    console.error(`🔧 Tool: ${toolName}, 📁 File: ${filePath}`);

    // 규칙 1: .env 파일 접근 제어
    if (filePath.startsWith('.env')) {
        if (toolName === 'Read' || toolName === 'Grep') { // 대문자로 수정
            console.error("❌ 보안 규칙 위반: .env 파일은 읽을 수 없습니다. 작업이 차단되었습니다.");
            process.exit(2); // 작업 차단
        }
    }

    // 규칙 2: 마이그레이션 파일 수정 제어
    if (filePath.includes('src/db/migrations/')) {
        if (toolName === 'Edit' || toolName === 'Write' || toolName === 'MultiEdit') { // 대문자로 수정
            console.error("❌ 데이터 불변성 규칙 위반: 마이그레이션 파일은 수정할 수 없습니다. 새 마이그레이션 파일을 생성하세요. 작업이 차단되었습니다.");
            process.exit(2); // 작업 차단
        }
    }

    // 규칙 3: 서비스 파일 문서화 정책
    if (filePath.includes('src/services/')) {
        if (toolName === 'Create' || toolName === 'Edit' || toolName === 'Write') { // 대문자로 수정
            const content = data.tool_input.content || '';
            if (!content.includes('@author')) {
                console.error("❌ 문서화 규칙 위반: 서비스 파일에는 반드시 '@author' JSDoc 태그가 포함되어야 합니다. 작업이 차단되었습니다.");
                process.exit(2); // 작업 차단
            }
        }
    }

    // 위의 모든 규칙에 해당하지 않으면 작업을 허용합니다.
    console.error("✅ 모든 규칙 통과");
    process.exit(0);

} catch (error) {
    console.error(`❌ 디스패처 오류: ${error.message}`);
    console.error(`📄 받은 데이터: ${input}`);
    process.exit(2); // 오류 발생 시 작업 차단
}
