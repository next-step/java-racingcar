# 자동차 경주 게임
## 요구사항
- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.


## 기능 목록
- RacingCarApplication
    - Input을 받아와서 RacingCar를 진행함
    - RacingCar의 결과를 받아와서 output으로 전달
- Input (UI)
    - 세부 사항이 언제든 변경될 수 있다고 생각되서 인터페이스로 구현
    - InputView는 System.in 을 통해 입력값을 받음
- Output (UI)
    - 세부 사항이 언제든 변경될 수 있다고 생각되서 인터페이스로 구현
    - ResultView는 System.out 을 통해 결과값을 출력
- Service (비즈니스 로직)
    - Car (domain)는 실제 비즈니스 로직의 도메인
    - Cars (dto) 일급컬렉션으로 서로 다른 레이어간 값 전달 목적
    - Rule (strategy) 현재는 랜덤을 통해 전진하지만 다른 조건에 대해서 확장 대응하기 위한 인터페이스
    - RacingCarService (service) 실제 비즈니스 로직 구현 자동차를 이동시키고 결과값을 반환
- Utils
    - Preconditions는 객체를 생성 전, 필수값 체크 유틸
    - RandomUtils는 랜덤 함수를 통한 랜덤값 발생 유틸


