### 기능 요구 사항

- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

### 시나리오

Race 는 차들과 경기정보를 가지고 경기를 하는 서비스이다.
Race 는 경기정보에서 입력한 횟수만큼 loop 를 돈다(경기를 진행한다 -> Race.Racing)
Race 가 진행되면 차들한테 메세지를 보낸다 movable 하니?

각각의 차는 차는 각자의 movable strategy 으로 갈지 정한다.

Result view 는 현재 차들을 관리하는 Cars 객체의 위치로

결과를 display 한다.

### Todo

- InputView 이름 받게 수정
- Split 관련 Util 구현
- RacingInfo 이름 받게 수정
- RacingGame 에서 이름 출력하게 구현
- 우승자 로직 구현

### Done

- InputView 이름 받게 수정
- Split 관련 Util 구현
- RacingInfo 이름 받게 수정