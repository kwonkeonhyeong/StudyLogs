# Binance 데이터를 획득하고 역직렬화하기

Binance로부터 JSON 데이터를 획득하면 이를 Java 객체로 역직렬화 하는 과정이 필요함

바이낸스는 WebSocket을 이용하여 데이터를 전송.

이때 대용량 데이터 전송에 따른 대역폭을 아끼기 위해서 s, p, q와 같은 아주 짧은 키(key) 값을 사용한다.

![바이낸스 websocket으로부터 받은 데이터](img.png)

---

## 역직렬화

Jackson 라이브러리를 이용하여 json 데이터를 Java 객체로 역직렬화 한다.

이를 위해서 DTO를 생성한다.


**@JsonIgnoreProperties(ignoreUnknown = true)**

위 애노테이션은 json 데이터에서 굳이 역질렬화에 포함되지 않아도 되는 데이터가 있을 때, 관심 없는 데이터는 무시하고 역직렬화를 진행할 수 있게 해준다.


**@JsonProperty("s")**

위 애노테이션은 json에 "s"라는 키 값을 가진 데이터를 필드와 연결해줍니다.



