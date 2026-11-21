# Racing Car todos (step4)
## 차
- [X] 처음 위치는 0이다
- [X] 값이 4 이상이면 위치가 1 증가한다
- [X] 값이 3 이하면 위치가 그대로다
- [X] 차는 이름을 가진다
  - [X] 차의 이름은 5자를 초과할 수 없다, 초과하면 IllegalArgumentException
  - [X] 차의 이름은 null 이거나 비어있거나 공란으로만 이루어져 있으면 IllegalArgumentException
## 경주
- [X] 입력한 횟수만큼 회차를 진행한다
  - [X] 입력한 횟수가 음수면 IllegalArgumentException
- [X] 입력한 자동차 이름으로 자동차를 생성한다
  - [X] (추가 규칙) 자동차 이름이 중복되면 IllegalArgumentException
- [X] 회차마다 각 차들은 전진할지 판단한다
- [X] 각 회차마다 차들의 상태를 조회할 수 있다
- [X] (추가 규칙) 경주는 한 번만 진행할 수 있다
- [X] 회차가 끝나면 우승자를 판별할 수 있다
  - [X] 우승자는 한 명 이상일 수 있다
## 입력
- [X] 시도 횟수를 숫자로 입력받는다
  - [X] 숫자가 아닌 입력은 IllegalArgumentException
  - [X] 음수인 입력은 IllegalArgumentException
- [X] 경주할 자동차 이름을 입력받고 쉼표(,)로 구분한다
  - [X] (추가 규칙) 쉼표 전후의 이름을 둘러싼 공백은 잘라낸다
  - [X] (추가 규칙) 동일한 이름이 중복해서 입력되면 IllegalArgumentException
  - [X] (추가 규칙) , 사이 공란이나 빈 입력이 들어오면 IllegalArgumentException
  - [X] 차의 이름은 5자를 초과할 수 없다, 초과하면 IllegalArgumentException
## 출력
- [X] 각 회차가 진행된 후, 각 차들의 이름과 누적 전진 거리를 - 기호로 출력한다 (예: pobi : ---)
- [X] 회차 사이를 빈 줄로 구분한다
- [ ] 경기를 마친 후 우승자를 출력한다 (예: pobi, honux가 최종 우승했습니다.)
