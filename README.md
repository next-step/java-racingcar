# 개발 요구 사항 정리

### 1.자동차

**[기능]**
- 자동차는 경주 진행자로부터 전달받은 값이 random 값이 4이상일 경우 움직인다.
- 자동차 동작 기록을 출력한다.
- **각 자동차마다 이름을 가지고 있다.** (요구사항 추가)

**[테스트]**
- 자동차가 전달받는 값이 4보다 큰 경우 동작해야한다.
- 자동차가 전달받는 값이 4보다 작은 경우 동작하지 않아야한다.
- **I/O 출력기에 의해 전달받은 이름이 자동차에 설정되어야 한다.** (요구사항 추가)

### 2.경주 진행자

**[기능]**
- 경주를 진행한다.
- 자동차가 움직일 신호를 발생한다.
- 경주가 끝난 경우 경주를 종료한다.
- 경주 기록을 출력한다.
- **자동차 경주 게임을 완료완 후 누가 우승했는지 알려준다.** (요구사항 추가)

**[테스트]**
- 경주 진행자는 자동차가 동작한 횟수와 경주 기록이 일치하는지 검증한다.
- **가장 먼거리를 이동한 자동차가 우승했는지 검증한다.** (요구사항 추가)
- **가장 먼거리를 이동한 자동차가 한 개 이상일경우 우승자도 한 명 이상이다.** (요구사항 추가)

### 3.난수 생성기
**[기능]**
- 게임이 시작된 이후 난수를 생성한다.

**[테스트]**
- 테스트 생략

### 4.I/O 출력기
**[기능]**
- 경주할 자동창의 개수를 입력 받는다.
- 경주할 자동차의 횟수를 입력받는다.
- 자동차의 경주기록을 결과를 출력한다.
- **경주할 자동차의 이름을 입력받아야한다.** (요구사항 추가)
- **경주할 자동차의 이름은 5글자가 넘어가면 안된다** (요구사항 추가)

**[테스트]**
- 요구사항으로 인해 UI 입력기는 테스트에서 제외.
