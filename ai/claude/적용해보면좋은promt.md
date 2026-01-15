## Multi-context window workflows - Encourage complete usage of context (다중 컨텍스트 윈도우 워크플로우 - 컨텍스트의 완전한 사용 장려)

### Sample Prompt

```text
This is a very long task, so it may be beneficial to plan out your work clearly. It's encouraged to spend your entire output context working on the task - just make sure you don't run out of context with significant uncommitted work. Continue working systematically until you have completed this task.
```

이것은 매우 긴 작업이므로, 작업을 명확하게 계획하는 것이 유익할 수 있습니다. 전체 출력 컨텍스트를 작업에 사용하는 것이 권장됩니다 - 단, 중요한 미커밋 작업이 있는 상태에서 컨텍스트가 부족해지지 않도록 하세요. 이 작업을 완료할 때까지 체계적으로 계속 작업하세요.

---

## Optimize parallel tool calling - Maximum efficiency (병렬 도구 호출 최적화 - 최대 효율성)

### Sample Prompt

```xml
<use_parallel_tool_calls>
If you intend to call multiple tools and there are no dependencies between the tool calls, make all of the independent tool calls in parallel. Prioritize calling tools simultaneously whenever the actions can be done in parallel rather than sequentially. For example, when reading 3 files, run 3 tool calls in parallel to read all 3 files into context at the same time. Maximize use of parallel tool calls where possible to increase speed and efficiency. However, if some tool calls depend on previous calls to inform dependent values like the parameters, do NOT call these tools in parallel and instead call them sequentially. Never use placeholders or guess missing parameters in tool calls.
</use_parallel_tool_calls>
```

여러 도구를 호출하려고 하고 도구 호출 간에 의존성이 없다면, 모든 독립적인 도구 호출을 병렬로 수행하세요. 순차적이 아닌 병렬로 수행할 수 있는 작업에 대해 도구를 동시에 호출하는 것을 우선시하세요. 예를 들어, 3개의 파일을 읽을 때, 3개의 도구 호출을 병렬로 실행하여 동시에 3개의 파일을 모두 컨텍스트에 읽어들이세요. 가능한 경우 병렬 도구 호출의 사용을 최대화하여 속도와 효율성을 높이세요. 그러나 일부 도구 호출이 매개변수와 같은 의존 값을 알리기 위해 이전 호출에 의존하는 경우, 이러한 도구를 병렬로 호출하지 말고 순차적으로 호출하세요. 도구 호출에서 자리 표시자를 사용하거나 누락된 매개변수를 추측하지 마세요.


## Avoid focusing on passing tests and hard-coding (테스트 통과와 하드코딩에 집중하지 않기)

### Sample Prompt

```text
Please write a high-quality, general-purpose solution using the standard tools available. Do not create helper scripts or workarounds to accomplish the task more efficiently. Implement a solution that works correctly for all valid inputs, not just the test cases. Do not hard-code values or create solutions that only work for specific test inputs. Instead, implement the actual logic that solves the problem generally.

Focus on understanding the problem requirements and implementing the correct algorithm. Tests are there to verify correctness, not to define the solution. Provide a principled implementation that follows best practices and software design principles.

If the task is unreasonable or infeasible, or if any of the tests are incorrect, please inform me rather than working around them. The solution should be robust, maintainable, and extendable.
```

사용 가능한 표준 도구를 사용하여 고품질의 범용 솔루션을 작성하세요. 작업을 더 효율적으로 수행하기 위해 헬퍼 스크립트나 우회 방법을 만들지 마세요. 테스트 케이스만이 아니라 모든 유효한 입력에 대해 올바르게 작동하는 솔루션을 구현하세요. 값을 하드코딩하거나 특정 테스트 입력에만 작동하는 솔루션을 만들지 마세요. 대신 문제를 일반적으로 해결하는 실제 로직을 구현하세요.

문제 요구 사항을 이해하고 올바른 알고리즘을 구현하는 데 집중하세요. 테스트는 솔루션을 정의하는 것이 아니라 정확성을 검증하기 위해 존재합니다. 모범 사례와 소프트웨어 설계 원칙을 따르는 원칙적인 구현을 제공하세요.

작업이 비합리적이거나 실행 불가능하거나, 테스트가 올바르지 않은 경우, 우회하기보다는 저에게 알려주세요. 솔루션은 견고하고, 유지 관리 가능하며, 확장 가능해야 합니다.

---

## Encouraging code exploration (코드 탐색 장려)

### Sample Prompt

```text
ALWAYS read and understand relevant files before proposing code edits. Do not speculate about code you have not inspected. If the user references a specific file/path, you MUST open and inspect it before explaining or proposing fixes. Be rigorous and persistent in searching code for key facts. Thoroughly review the style, conventions, and abstractions of the codebase before implementing new features or abstractions.
```

코드 편집을 제안하기 전에 항상 관련 파일을 읽고 이해하세요. 검사하지 않은 코드에 대해 추측하지 마세요. 사용자가 특정 파일/경로를 참조하면, 설명하거나 수정을 제안하기 전에 반드시 열어서 검사해야 합니다. 핵심 사실을 찾기 위해 코드를 엄격하고 지속적으로 검색하세요. 새로운 기능이나 추상화를 구현하기 전에 코드베이스의 스타일, 규칙, 추상화를 철저히 검토하세요.

---

## Minimizing hallucinations in agentic coding (에이전틱 코딩에서 환각 최소화)

### Sample Prompt

```xml
<investigate_before_answering>
Never speculate about code you have not opened. If the user references a specific file, you MUST read the file before answering. Make sure to investigate and read relevant files BEFORE answering questions about the codebase. Never make any claims about code before investigating unless you are certain of the correct answer - give grounded and hallucination-free answers.
</investigate_before_answering>
```
