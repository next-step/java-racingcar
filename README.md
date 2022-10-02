# 자동차 경주 게임

## 3단계 - 자동차 경주

### 기능 요구사항

- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 기능 구현 목록

- [X] 자동차 대수를 입력받는다.
  - 숫자가 아니거나 양수가 아닌 경우 예외처리
- [X] 시도할 회수를 입력받는다.
  - 숫자가 아니거나 양수가 아닌 경우 예외처리
- [X] 자동차를 전진시킨다.
  - 0에서 9 사이에서 random 값을 구한 후 4이상일 경우 전진시키고, 3이하일 경우 멈춘다.
- [X] 매 시도마다 각 차량 이동 상태 결과를 출력한다.
  - 이동 상태를 "-"로 출력한다.
  - 자동차 대수만큼 출력한다.
  - 시도 회수만큼 출력한다.

## 4단계 - 자동차 경주(우승자)

### 기능 요구사항

- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

### 기능 구현 목록

- [X] 경주할 자동차 이름을 입력받는다.
  - 각 자동차 이름을 쉼표로 구분
    - 자동차 이름이 5자를 초과할 경우 예외처리
    - 자동차 이름이 빈문자열일 경우 예외처리
- [X] 시도할 회수를 입력받는다. (기존 요구사항)
  - 숫자가 아니거나 양수가 아닌 경우 예외처리
- [X] 자동차 이름 수만큼 자동차를 생성한다.
- [X] 매 전진 시도마다 각 차량 이동 상태 결과를 자동차 이름과 함께 출력한다.
- [X] 자동차 경주 우승자를 선별한다.
  - 우승자가 한 명 이상일 수 있음
- [ ] 자동차 경주 우승자를 출력한다.
  - 우승자가 한 명 이상일 경우 모든 우승자 이름 출력
