## 자동차 경주 게임 (Step5)
### 기능 요구사항
1. 사용자는 쉼표(,)를 기준으로 자동차 이름을 입력할 수 있다.
2. 자동차 이름은 5자 이하만 가능하다.
3. 사용자는 시도 횟수를 입력할 수 있다.
4. 사용자는 자동차 경주 게임을 시작할 수 있다.
5. 각 자동차는 매 시도마다 0부터 9까지의 랜덤 숫자를 받는다.
6. 랜덤 숫자가 4 이상일 경우 자동차는 한 칸 전진한다.
7. 모든 시도가 끝나면 우승자를 발표한다. 우승자는 가장 멀리 간 자동차이다. 우승자가 여러 명일 경우 모두 출력한다.

### 비기능 요구사항
1. MVC 패턴을 적용한다.
2. 함수(또는 메서드)의 길이가 15라인을 넘지 않는다.
3. 함수(또는 메서드)의 들여쓰기 깊이가 2를 넘지 않는다.
4. 모든 로직에 단위 테스트를 구현한다.

### 도메인 설계
- Car
    - name: CarName
    - position: Location
    - move(): void // 숫자가 4 이상일 경우 위치를 한 칸 전진시킨다.
- CarName
    - name: String
    - validate(): void // 이름이 5자 초과일 경우 예외 발생
- Cars
    - cars: List<Car>
    - race(): void // 모든 자동차에 대해 move()를 호출한다.
    - getWinners(): Winners // 가장 멀리 간 자동차들을 반환한다
- CarsFactory
    - createCars(): Cars
- Location
    - position: int
    - moveForward(): void // 위치를 한 칸 전진시킨다.
    - maxPosition(other: Location): racing.model.Location
    - isSamePosition(other: Location): Boolean
- RaceGame
    - cars: Cars
    - round : Round
    - play() : void
    - getWinners(): Winners
- Round
    - count: int
    - isPlaying(): void 
    - decrease(): void // 시도 횟수를 1 감소시킨다.
- Winners
    - winners: List<Car>
    - toString(): String // 우승자 이름들을 쉼표(,)로 구분한 문자열로 반환한다.

