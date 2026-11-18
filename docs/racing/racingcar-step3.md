# Racing Car todos (step3)
## 입력
- [X] 자동차 대수와 횟수를 숫자로 입력받는다
  - [X] 숫자가 아닌 입력은 IllegalArgumentException
  - [X] 음수인 입력은 IllegalArgumentException
## 차
- [X] 처음 위치는 0이다
- [X] 이동 규칙이 허용하면 위치가 1 증가한다
- [X] 이동 규칙이 허용하지 않으면 위치가 그대로다
## 이동 규칙
- [X] 값이 4 이상이면 전진한다
- [X] 값이 3 이하면 이동하지 않는다
## 랜덤값 생성
- [X] 0 ~ 9 사이의 값을 생성한다
## 경주
- [X] 입력한 횟수만큼 회차를 진행한다
  - [X] 입력한 횟수가 음수면 IllegalArgumentException
- [X] 입력한 자동차 대수만큼 자동차를 생성한다
  - [X] 입력한 대수가 음수면 IllegalArgumentException
- [X] 회차마다 각 차들은 전진할지 판단한다
## 출력
- [X] 각 회차가 진행된 후, 각 차들의 누적 전진 거리를 - 기호로 출력한다
- [X] 회차 사이를 빈 줄로 구분한다