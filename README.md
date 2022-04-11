# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 구현할 기능 목록

### Car Class

|접근 제어자|속성|설명|
|------|---|---|
|```private```|```id: Long```|자동차의 id|
|```private```|```distance: int```|자동차가 전진한 거리|
|----------------|----------------|----------------|
|```private```|```move():void```|자동차가 한칸 전진하다. (distance의 값이 1 증가한다)|
|```private```|```canMove(value: int): Boolean```| 자동차가 전진할 수 있는가  |
|```private```|```getDistance(): int```| 자동차가 지나간 거리를 반환한다.  |


#### 테스트 케이스
- ```canMove(value: int)``` 메서드에  ```value``` parameter가 4 이상일때  true를 반환한다.
- ```run()``` distance가 1 증가한다.
- ```getDistane()``` distance를 반환한다.

### RacingGame Class

|접근 제어자|속성|설명|
|------|---|---|
|```private```|```cars:  List<Car>```|경주에 참가한 자동차들|
|```private```|```round: int```|경기 라운드|
|```private```|```result: ResultView```|자동차가 달려간 거리를 담고있는 리스트|
|----------------|----------------|----------------|
|```public```|```play(): void```|경기를 시작한다.|
|```private```|```dispatch(): void```|경기 진행상태를 ResultView에 보낸다.|


### InputView Class
|접근 제어자|속성|설명|
|------|---|---|
|```private```|```carCount: int```|게임에 참가할 자동차의 개수를 입력 받는다.|
|```private```|```round: int```|게임을 진행할 라운드를 입력받는다.|
|----------------|----------------|----------------|
|```private```|```InputView(carCount: int, round: int): RacingGame```|RacingGame을 생성한다.|

#### 테스트 케이스
- ```InputView()```:  자동차 개수가 ```carCount```,  round가 ```round```인 ```RacingGame```을 생성한다. 

### ResultView Class
|접근 제어자|속성|설명|
|------|---|---|
|```private```|```result: List<Map<Long, String>>```|자동차가 달려간 거리를 담고있는 리스트|
|----------------|----------------|----------------|
|```private```|```print(): void```|자동차가 달려간 거리를 출력한다.|
|```private```|```sumDistance(distances: List<Map<Long, String>>): void```|라운드 별로 자동차가 달려간 거리를 더한다.|

#### 테스트 케이스
```print()``` 출력이 된다.
```sumDistance(List<Map<Long, String>>)``` 