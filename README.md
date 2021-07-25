# 자동차 경주 게임

## 요구 사항

* 초간단 자동차 경주 게임을 구현한다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
* 값을 입력 받는 API는 Scanner를 이용한다.
* 랜덤 값은 자바 java.util.Random 클래스의 nextInt(10) 메소드를 활용한다.

## 주요 기능 목록
* java-racingcar/src/main/java/racingcar
    - /RacingcarApplication.java : 자동차 경주 게임 main 메소드로 Racing을 호출하여 게임을 시작한다.
    - /Racing.java : 게임의 준비, 시작 등 게임을 구성하고 있다.
    
* java-racingcar/src/main/java/racingcar/car
    - /car/Car.java : 자동차 경주 게임에 참여하는 자동차
    - /car/Cars.java : 자동차 경주 게임에 참여하는 모든 자동차들의 List
    - /car/Position.java : Car의 position 관리한다. (Atomic Type 사용)
    
* java-racingcar/src/main/java/racingcar/exception
    - /InvalidCarException.java : Car에 대한 exception 처리
    - /InvalidUserInputException.java : 사용자 입력 값에 대한 exception 처리
    
* java-racingcar/src/main/java/racingcar/util/
    - /Util.java : 랜덤 숫자를 생성하는 메소드가 존재하는 Util 클래스
    - /ValidationUtil.java : 해당 클래스를 통해 validation 체크를 하고 오류 발생 시 throw Exception 시킨다.
   
* java-racingcar/src/main/java/racingcar/view
    - /InputView.java : 게임 시작 시 사용자가 입력해야 하는 값들에 대한 처리를 한다.
    - /ResultView.java : 경주 시 실행 결과를 출력해주는 처리를 한다.