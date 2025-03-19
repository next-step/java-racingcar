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
    - 내부 클래스 사용
  - 자동차 경주 게임 결과 출력하기
    - 결과 출력은 별도의 객체로
## RacingCar
- RacingCar가 가져야 할 기능
  - 이동
    - 이동 전략을 생성자에서 받아서 활용
  - 현재 위치 알려주기
## RacingGameResult
- Car를 원소로 갖는 집합을 필드로 갖는 일급 컬렉션
