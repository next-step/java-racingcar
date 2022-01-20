
# 🚀 1단계 - 자동차 경주
## 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

### Console class 
- [X] 각 자동차에 이름을 부여할 수 있다.  - class Console
- setRacingCarNames(): 자동차 이름을 받아 5자 초과하는지 여부를 판별한 후 쉼표로 split 해서 racingCarNames에 저장 
- [X] 시도할 횟수를 입력 받는다. - setTryCount()
  - [X] 자동차 이름은 5자를 초과할 수 없다. - validateNameLength()
  - [X] 자동차 이름은 쉼표(,)를 기준으로 구분한다. 


### RacingCarGame class
- racingCarList, tryCount
- [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한다. - getRandomMove()
    - [ ] 무작위 값이 4 이상일 경우이다. - validateRandomMove()
- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. - controlRacingCar() while 돌고, getRandomMove 값 얻어오고 
- [ ] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. - printRacingResults()
  - [ ] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. - printGameResult()
