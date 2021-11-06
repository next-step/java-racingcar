# 자동차 경주 게임

## 요구사항

- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

## 기능 목록

- RacingCarApplication
    - RacingCar 애플리케이션을 실행
- RacingCarController
    - Input을 받아와서 RacingCar를 진행함
    - RacingCar의 결과를 받아와서 output으로 전달
- UI
    - InputView (UI)
        - 세부 사항이 언제든 변경될 수 있다고 생각되서 인터페이스로 구현
        - RacingCarInputView는 Racing에 필요한 입력값을 받아옴
    - OutputView (UI)
        - 세부 사항이 언제든 변경될 수 있다고 생각되서 인터페이스로 구현
        - ResultCarOutputView Racing의 결과를 출력
- Service (비즈니스 로직)
    - domain
        - Car (domain)는 실제 비즈니스 로직의 도메인
        - Car를 생성해주는 Factory 클래스
    - model
        - Record는 매 Round 별로 결과를 기록하는 객체
    - dto
        - RoundReady는 Controller Layer에서 Service Layer에 값을 전달하기 위한 DTO
        - RoundResult는 Service Layer에서 Controller Layer에 레이스 결과값을 전달하기 위한 DTO
    - strategy
        - RoundRule (strategy) 현재는 랜덤을 통해 전진하지만 다른 조건에 대해서 확장 대응하기 위한 인터페이스
        - RandomRoundRule 는 10개의 랜덤값 중, 4초과의 값이 나오면 참을 반환 4이하의 값이 나오면 거짓을 반환
        - RacingCarService (service) 실제 비즈니스 로직 구현 자동차를 이동시키고 결과값을 반환
- Utils
    - InputUtils는 입력값을 받아서 문자열 또는 숫자로 반환 해주는 유틸
    - OutputUtils는 출력값을 받아서 Console에 출력해 주는 유틸
    - Preconditions는 객체를 생성 전, 필수값 체크 유틸
    - RandomUtils는 랜덤 함수를 통한 랜덤값 발생 유틸
