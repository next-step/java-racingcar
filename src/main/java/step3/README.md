# Introduction
## 자동차 경주
### requirement
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

# Features
### 경주: `Race`
경기에 참여하는 `자동차 대수`를 가지고 자동차 경주를 진행
* `void lap()`: 한 `회` 경주
* `List<Car> getCars()`: 경기중인 `자동차`들

### 자동차: `Car`
* `void run(int throttle)`: 한 `차례` 자동차 이동 시도 (`throtle`이 적절할때만 이동)
* `int getThrottle()`: 이번 차례의 `throtle` 가져오기 
* `int getCurrentPosition()`: 자동차의 현재 위치

### 입력 UI: `InputView`
* `int readNumberCars()`: `자동차 대수` 입력받기
* `int readIterations()`: `주어진 횟수` 입력받기

### 출력 UI: `OutputView`
* `void showStatus(Car)`: 한 자동차의 `현재 진행 상태`를 출력
* `void showStatus(List<Car>)`: 자동차들의 `현재 진행 상태`를 모두 출력
