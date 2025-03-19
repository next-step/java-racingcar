# Issues
## InputView
- View가 가져야 할 기능
  - 사용자 입력 받기
  - 사용자 입력 검증하기
    - 검증은 View, Model 모두에서 수행하되 서로 다른 부분을 수행
  - 사용자 입력 반환하기
    - 질문을 파라미터로 받고 사용자 입력을 반환하는 메서드
- View와 Model은 독립적이어야 함
  - View에서 경주, 차량 등의 개념을 가지면 안됨
- ByteInputStream과 System.in의 차이
  - 테스트에서 사용자 입력을 구현하기 위해 `ByteInputStream`을 사용
  - `ByteInputStream`은 `System.in`을 대체할 수 있으나 공백, 개행문자로만 끝날 경우에는 서로 다르게 동작
    - `System.in`은 사용자 입력이 끝나지 않으면 계속 대기
## RacingGame
- RacingGame이 가져야 할 기능
  - 자동차 경주 게임 시작하기
    - 입력값 검증하기
  - 자동차 경주 게임 진행하기
    - 생성 시 0 이하의 값이 들어오지 않도록 검증하므로 `progress >= 0`은 테스트에서 불필요
  - 자동차 경주 게임 결과 출력하기
    - 결과 출력은 별도의 객체로
## RacingCar
- RacingCar가 가져야 할 기능
  - 이동
    - 이동 전략을 생성자에서 받아서 활용
  - 현재 위치 알려주기
## RacingGameResult
- RoundResult를 모아 게임의 모든 결과를 저장
- 가져야 할 기능
  - 모든 결과 반환
  - 마지막 결과 반환
  - 새로운 결과 저장
## RoundResult
- 각각 시도 별로 차량의 위치를 저장
