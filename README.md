# 자동차 경주 게임
---
### 콘솔 입출력 처리
- ConsoleWriter : 출력
- ConsoleScanner : 입력 처리
- InputView : 입력 데이터 홀더 클래스

### 레이싱게임
- RacingGame
  - RacingGame#move : 게임 1턴 시작
  - RacingGame#findWinner : 현재 우승자 찾기

### 자동차
- Car
  - Car#move : 자동차 이동 

### 난수생성기
- RandomGenerator

### 이동전략
- MovingStrategy
  - RandomMoveStrategy::isMove : 랜덤으로 이동 여부 결정
  - AlwaysMoveStrategy::isMove : 항상 이동
  - NotMoveStrategy::isMove : 항상 이동하지 않음