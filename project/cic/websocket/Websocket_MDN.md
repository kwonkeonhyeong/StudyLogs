# Websocket

HTTP와 WebSocket의 가능 큰 차이는 수립된 커넥션을 어떻게 하는가에 있다.

Http -> 비연결성, 매번 연결 맺고 끊는 과정의 비용 (요청 - 응답 구조)

웹 소켓 -> 연결 지향, 한번 연결 맺은 뒤 유지, 양방향 통신

웹 소켓은 텍스트와 바이너리로 이루어진 메시지를 양뱡향으로 주고 받을 수 있는 프로토콜이다. 

https://www.youtube.com/watch?v=rvss-_t6gzg&t=462s

웹소켓은 사용자의 브라우저와 서버 간에 양방향 상호작용 통신 세션을 열 수 있게 해줍니다.

웹 소켓은 HTTP로 시작하지만, 곧바로 프로토콜 업그레이드를 통해 양방향 통신 채널을 만듭니다.

- HandShake : 클라이언트가 Upgrade: websocket 헤더를 담은 HTTP 요청을 보내면, 서버가 101 Switching Protocols 로 응답하며 연결이 확정됩니다.
- Stateful : HTTP는 요청-응답 후 연결을 끊는 Stateless 방식이지만, 웹소켓은 한 번 연결되면 명시적으로 끊기 전까지 TCP 연결을 유지합니다.
- Framing : 데이터는 '프레임' 단위로 쪼개져 전달됩니다.

WebSocket은 HTTP Upgrade 헤더를 사용하여 WebSocket 프로토콜로 업그레이드하거나 전환하는 HTTP 요청으로 시작됩니다. 

업그레이드 요청의 성공적인 핸드 셰이크 후, 해당 TCP 소켓은 클라이언트와 서버가 메시지를 계속 주고받을 수 있도록 열려 있습니다.

---

## Http vs Websocket

웹 소켓은 Http와 호환되도록 설계되어 있고 HTTP 요청으로 시작되지만, 두 프로토콜이 매우 다른 아키텍처와 애플리케이션 프로그래밍 모델로 이어집니다.

HTTP와 REST에서는 애플리케이션이 여러 개의 URL로 모델링됩니다. 애플리케이션과 상호작용하기 위해 클라이언트는 이러한 URL에 접근하여 요청-응답 방식으로 작동합니다.

서버는 HTTP URL, 메서드 및 헤더에 따라 요청을 적절한 핸들러로 라우팅합니다.

대조적으로, WebSockets에서는 초기 연결을 위한 URL이 보통 하나뿐입니다. 

그 이후에는 모든 애플리케이션 메시지가 동일한 TCP 연결을 통해 흐릅니다. 이는 완전리 다른 비동기 이벤트 기반 메시징 아키텍처를 나타냅니다.

WebSocket은 또한 저수준 전송 프로토콜로, HTTP와 달리 메시지 내용에 대한 의미를 규정하지 않습니다. 

이는 클라이언트와 서버가 메시지 의미에 대해 합의하지 않는 한 메시지를 라우팅하거나 처리할 방법이 없다는 것을 의미합니다.

WebSocket 클라이언트와 서버는 HTTP 핸드셰이크 요청의 Sec-WebSocket-Protocol 헤더를 통해 더 높은 수준의 메시징 프로토콜(예: STOMP)를 사용할 수 있도록 협상할 수 있습니다.




---

## Writing WebSocket client Application

실제 애플리케이션에서는 웹 페이지가 HTTPS를 사용하여 제공되어야 하며, WebSocket 연결은 프로토콜로 wss를 사용해야 합니다.

client에서 WebSocket 인스턴스를 생성하면 server와의 연결을 설정하는 과정이 시작됩니다. 

연결이 설정되면 open 이벤트가 발생하며, 이 시점부터 소켓은 데이터를 전송할 수 있습니다.

연결이 설정되는 동안 또는 설정된 후 언제든지 오류가 발생하면 error 이벤트가 발생합니다.

연결이 설정되면 send() 메서드를 사용하여 서버에 메시지를 보낼 수 있습니다.

일반적으로는 JSON을 사용하여 직영화 된 객체를 Text로 전송하며 Blob, ArrayBuffer, TypedArray 또는 DataView와 같은 이진 데이터를 전송할 수도 있습니다.

client는 server로부터 메시지를 받기 위해, message 이벤트를 수신합니다.

server는 또한 이진 데이터를 전송할 수 있으며, 이는 Websocket.binaryType 속성의 값에 따라 클라이언트에 Blob 또는 ArrayBuffer로 노출됩니다.

server는 또한 JSON 문자열을 전송할 수 있으며, client는 이를 객체로 파싱할 수 있습니다.

연결이 종료되면, client나 server가 이를 닫았거나 오류가 발생했기 때문에 close 이벤트가 발생합니다.

WebSockets는 혼합 콘텐츠 환경에서 사용해서는 안 됩니다. 즉, HTTPS로 로드된 페이지에서 비보안 WebSocket 연결을 열거나 그 반대의 경우를 피해야 합니다.

대부분의 브라우저는 이제 보안 WebSocket 연결만 허용하며, 비보안 환경에서의 사용은 더 이상 지원하지 않습니다.

---

## Writing WebSocket server Application

WebSocket server는 **Berkeley 소켓**을 사용할 수 있는 모든 server 측 프로그래밍 언어로 작성할 수 있습니다.

https://datatracker.ietf.org/doc/rfc6455/?include_text=1
최신 공식 WebSockets 사양인 RFC 6455를 읽어보세요. 섹션 1과 4-7은 server 구현자에게 특히 흥미롭습니다. 섹션 10에서는 보안에 대해 논의하며, server를 노출하기 전에 반드시 살펴보아야 합니다.

WebSocket server는 종종 별도의 전문 server(로드 밸런싱 또는 기타 실용적인 이유로)로 운영되므로, 

WebSocket 핸드셰이크를 감지하고 이를 사전 처리한 후 실제 WebSocket server로 client를 전송하기 위해 리버스 프록시(일반 HTTP server와 같은)를 자주 사용하게 됩니다.

먼저, server는 표준 TCP 소켓을 사용하여 들어오는 소켓 연결을 수신해야 합니다. 

server를 구축하더라도 client는 여전히 server에 연락하여 WebSocket 연결을 요청합으로써 WebSocket 핸드셰이크 프로세스를 시작해야 합니다. 

(HTTP 버전은 1.1 이상이어야 하며, 메서드는 GET이어여 합니다)

```http request
GET /chat HTTP/1.1
Host: example.com:8000
Upgrade: websocket
Connection: Upgrade
Sec-WebSocket-Key: dGhlIHNhbXBsZSBub25jZQ==
Sec-WebSocket-Version: 13
```

client는 여기에서 확장 또는 하위 프로토콜을 요청할 수 있습니다.

헤더가 이해되지 않거나 잘못된 값이 있는 경우, 서버는 400 응답을 보내고 즉시 소켓을 닫아야 합니다.

서버가 해당 WebSocket 버전을 이해하지 못하는 경우, 이해하는 버전이 포함된 Sec-WebSocket-Version 헤더를 다시 보내야 합니다. 

> 일반 HTTP 상태 코드는 햔드셰이크 이전에만 사용 가능합니다. 핸드셰이크가 성공한 후에는 다른 코드 집합을 사용해야 합니다.

서버가 핸드셰이크 요청을 받으면, 프로토콜이 HTTP에서 WebSocket으로 변경될 것임을 나타내는 특별한 응답을 보내야 합니다.

해당 헤더는 다음과 같은 형태를 띱니다. (각 헤더 라인은 /r/n으로 끝나며, 마지막 헤더 뒤에는 헤더의 끝을 나타내기 위해 추가로 /r/n을 넣어야 합니다.)

```http request
HTTP/1.1 101 Switching Protocols
Upgrade: websocket
Connection: Upgrade
Sec-WebSocket-Accept: s3pPLMBiTxaQ9kYGzzhZRbK+xOo=
```
Sec-WebSocket-Accept 헤더는 서버가 클라이언트가 보낸 Sec-WebSocket-Key에서 파생해야 하므로 중요합니다.

이를 얻으러면 Sec-WebSocket-Key와 "258EAFA5-E914-47DA-95CA-C5AB0DC85B11"를 함께 연결(이것은 "마법 문자열"입니다)하고, 결과의 SHA-1 해시를 취한 다음, 그 해시의 base64 인코딩을 반환합니다.

서버가 이러한 헤더를 전송하면 핸드셰이크가 완료되고 데이터 교환을 시작할 수 있습니다.

> 이렇게 복잡해 보이는 과정은 클라이언트가 서버가 WebSockets를 지원하는지 여부를 명확히 알 수 있도록 존재합니다. 
> 
> 이는 서버가 WebSockets 연결을 수락하지만 데이터를 HTTP 요청으로 해석할 경우 보안 문제가 발생할 수 있기 때문에 중요합니다.
>
> 서버는 Set-Cookie와 같은 다른 헤더를 전송하거나, 응답 핸드세이크를 전송하기 전에 인증이나 리디렉션을 요청할 수 있습니다.

클라이언트나 서버는 언제든지 메시지를 전송할 수 있습니다.

모든 프레임이 동일한 특정 형식을 따르지만, 클라이언트에서 서버로 전송되는 데이터는 XOR 암호화(32비트 키 사용)를 통해 마스킹됩니다.

각 데이터 프레임(클라이언트에서 서버로 또는 그 반대 방향)은 동일한 형식을 따릅니다.

> 데이터 프레임 관련 부분은 공식문서 확인하기
> https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API/Writing_WebSocket_servers


핸드셰이크 이후 언제든지 클라이언트나 서버는 상대방에게 핑을 보낼 수 있습니다.

핑이 수신되면 수신자는 가능한 한 빨리 퐁을 다시 보내야 합니다.

핑 또는 퐁은 일반 프레임이지만, 제어 프레임입니다. 핑의 opcode 는 0x9이고, 퐁의 opcode는 oxA입니다. 

핑을 받으면, 핑과 정확히 동일한 페이로드 데이터를 가진 퐁을 보내세요. 핑을 보내지 않고도 퐁을 받을 수 있으니, 그런 경우는 무시합니다.

퐁을 보낼 기회가 오기 전에 핑을 여러 번 받았다면, 퐁은 한 번만 보내세요.

연결을 종료하기 위해 클라이언트나 서버는 지정된 제어 시퀀스를 포함하는 데이터를 담은 제어 프레임을 보내어 종료 핸드 셰이크를 시작할 수 있습니다.

그러한 프레임을 수신하면 다른 피어는 응답으로 close 프레임을 보냅니다. 

첫 번째 피어는 그 후 연결을 종효압니다. 연결 종료 후 수신된 추가 데이터는 모두 폐기됩니다.


---

https://datatracker.ietf.org/doc/html/rfc6455
