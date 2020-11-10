# 3단계 - 자동차 경주

## 기능 요구사항
- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

---

### 구현 기능
#### InputView
1. 입력 API - input
2. 자동차 수 입력 멘트 및 입력 받기 - inputCarCount
3. 시도 회수 입력 멘트 및 입력 받기 - inputRacingCount

#### ResultView
1. 입력받은 메시지 출력 - printMessage
2. 개행 출력 - printCrlf
3. 전진 출력 - printForwardLine

#### Race
1. 객체초기화(자동차 수, 시도 회수 입력 받기)
2. 전진 여부 로직 - go
3. 시도 회수만큼 전진 로직 반복 - loopByRaceCount
4. 자동차 수만큼 시도 로직 반복 - loopByCarCount
5. 경주 시작 - start