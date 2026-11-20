
#### Name
- [X] 이름이 5자를 초과하면 IllegalArgumentException 예외를 던진다. (예: "longname" -> 예외)
- [X] 이름이 5자 이하이면 정상적으로 생성된다. (예: "pobi")

#### Car
- [X] 랜덤 값이 4 이상이면 위치가 1 증가한다. (예: 4 -> 위치 1)
- [X] 랜덤 값이 4 미만이면 위치가 그대로다. (예: 3 -> 위치 0)

#### Cars
- [X] 쉼표로 구분된 이름 개수만큼 자동차가 생성된다. (예: "pobi,crong,honux" -> 3대)
- [X] 가장 멀리 이동한 자동차가 우승자가 된다. (예: pobi 4, honux 3 -> pobi)
- [X] 최대 이동 거리가 같은 자동차가 여러 대면 모두 우승자가 된다. (예: pobi 4, honux 4, crong 3 -> pobi, honux)

#### AttemptCount
- [X] 시도 횟수가 0 또는 음수이면 IllegalArgumentException 예외를 던진다. (예: 0, -1 -> 예외)

#### RacingGame
- [X] 시도 횟수만큼 라운드가 진행되면 경주가 종료된다. (예: 5회 -> 5라운드 후 종료)

#### InputValidator
- [X] 숫자가 아닌 시도 횟수를 입력하면 IllegalArgumentException 예외를 던진다. (예: ";" -> 예외)
- [X] 이름 형식이 잘못되면 IllegalArgumentException 예외를 던진다. (예: "pobi,,crong", "pobi, crong" -> 예외)

#### OutputView
- [X] 자동차 이름과 위치를 함께 출력한다. (예: pobi 위치 2 -> "pobi : --")
- [X] 우승자가 한 명이면 이름을 출력한다. (예: pobi -> "pobi 가 최종 우승했습니다.")
- [X] 우승자가 여러 명이면 쉼표로 구분해 출력한다. (예: pobi, honux -> "pobi, honux 가 최종 우승했습니다.")