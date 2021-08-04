# 자동차 경주 게임

## 요구 사항

* 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
* 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분한다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
* 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.

## 주요 기능 목록
* java-racingcar/src/main/java/racingcar
    - /RacingcarApplication.java : 자동차 경주 게임 main 메소드로 게임을 시작하고 게임 결과를 출력한다.
    
* java-racingcar/src/main/java/racingcar/car
    - /car/Car.java : 자동차 경주 게임에 참여하는 자동차
    - /car/Cars.java : 자동차 경주 게임에 참여하는 모든 자동차들의 List
    - /car/Position.java : Car의 position을 관리한다.
    - /car/Name.java : Car의 name을 관리한다.
    
* java-racingcar/src/main/java/racingcar/exception
    - /InvalidCarException.java : Car에 대한 exception 처리
    - /InvalidUserInputException.java : 사용자 입력 값에 대한 exception 처리
    
* java-racingcar/src/main/java/racingcar/util/
    - /Util.java : 랜덤 숫자를 생성하는 메소드가 존재하는 Util 클래스
    - /ValidationUtil.java : 해당 클래스를 통해 validation 체크를 하고 오류 발생 시 throw Exception 시킨다.
   
* java-racingcar/src/main/java/racingcar/view
    - /InputView.java : 사용자가 입력해야 하는 값들에 대한 처리를 한다.
    - /ResultView.java : RaceResult에서 출력할때에 대한 처리를 한다.