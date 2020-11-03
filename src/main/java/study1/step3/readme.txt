

~ 전체 Controller class
    - Race.class
        = setting() : inputView class 선언 및 값 세팅
        = race() : 레이스 로직


~ inputView class
    - RaseSetting
        = 자동차 수, 레이스 수 입력 view class

~ outputView class
    - RaceBoard
        = RaceBoard : 선언할 때 실행 결과 print
        = show : 현 레이스 상황 출력

~ Decision
    - Decision Interface

~ MoveDecision
    - Race에서 사용되는 Random variable 기반 Car 전진 여부 판단 Class

~ FixedMoveDicision
    - Test에서 사용되는 Car 전진 여부 판단 Class (선언할 때 입력받는 값으로 고정)


