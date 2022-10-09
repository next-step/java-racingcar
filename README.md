# 자동차 경주 게임



## 패키지 구성



App : 프로그램의 전체 흐름을 관리하며 InputView로 부터 받은 데이터를 게임 시작을 위해 가공하는 책임을 지닌 객체



### domain

Car :  레이스에 참가하는 자동차 객체로 이동 전략에 따라 앞으로 가거나 멈춰있다.

CarGroup : 자동차들을 움직이고 우승자를 찾아내는 책임을 지닌 객체

RacingGame : 게임을 진행하고 결과값을 반환하는 책임을 지닌 객체

Name : 자동차 이름 객체

Position : 자동차 위치값 객체

- #### movingstrategy

  - MovingStragegy : 이동 전략 인터페이스
  - RandomNumberMovingStragegy : 랜덤 숫자를 돌려 특정 숫자 이상이 나오면 앞으로 가게 하는 이동 전략 구현 클래스 

  

### view

- InputView : 사용자 입력값을 검증하고 이를 App 객체에 전달하는 책임을 지닌 객체
- ResultView : 결과값으로 받은 데이터를 사용자에게 보여주는 책임을 지닌 객체
