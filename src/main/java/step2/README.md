# 2단계 - 자동차 경주
#### 기능 구현
* UI 를 담당하는 로직을 분리
    * ResultView
        * UI 를 담당
    * RacingGameResultModel
        * UI 를 그리기 위해 사용하는 모델
* 핵심 로직을 구현하는 코드
    * RacingGame : 도메인 로직을 수행하는 클래스
    * Car
        * 자동차 객체
        * move() 기능
    * Cars
        * 일급 콜렉션 객체
        * turn() 기능 : 한 time(한 turn) 이 지난 후 List\<Car\> 반환
    * RacingGameRecord
        * 각 turn 마다 Car 의 경주 기록, Cars(List\<Car\>) 를 기록
    * MoveStrategy
        * Car 객체가 전진할지 말지 판단하는 전략을 외부에서 주입받음