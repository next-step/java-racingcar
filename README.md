# 자동차 경주 게임

## 기능 목록
- RacingController
  - RacingGame을 생성한다.
  - 라운드 만큼 자동차 경주 게임을 진행한다.
- InputView
  - 자동차 대수를 입력받는다.
  - 시도할 횟수를 입력받는다.
- ResultView
  - 사용자가 입력한 정보에 따라 게임 진행 결과를 출력한다.
- MoveRule
  - RandomMoveRule
    - 특정 범위의 랜덤한 값을 생성후 이동 조건인지 판별한다.
- Model
  - RacingGame
    - 전달 받은 자동차수와 라운드수를 검증한다. 
    - 전달 받은 값 만큼 자동차(Car)를 생성한다.
    - 전달 받은 값 만큼 라운드(Round)를 생성한다.
    - 레이싱 게임을 수행한다.
  - Round
    - 라운드 정보를 저장한다.
    - 전달 받은 라운드수를 검증한다.
    - 수행해야할 라운드가 남아 있는지 정보를 제공한다.
  - Car
    - 게임을 진행하는 대상.
    - Round 에 따라 Position 정보를 변경한다.
  - Cars
    - Car 일급 컬렉션
    - 자동차의 현재 포지션을 정보를 제공한다.
    - 포함하는 자동차의 위치에 변경할 값을 제공한다.
  - Position
    - 현재 위치를 저장한다.
    - 현재 위치를 전달받은 수만큼 증가시킨다.
- util
  - RandomUtils 
  - ScannerUtils
  - NumberUtils