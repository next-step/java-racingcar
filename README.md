# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


### 모델링

**view**
- 사용자에게 이동시도 횟수 입력을 요청한다 (o)
- 사용자에게 자동차 대수 입력을 요청핟다 (o)
    - 검증위치 고민) 검증은 View를 거치고 비즈니스 로직 전에 하는게 좋아보임. View 분리 시를 생각해보자

- 자동차의 상태를 출력한다.
- 상태 출력은 매 경기에 대해 모두 출력해야 한다.

**레이싱게임**
- 참가 자동차들이 경기를 하도록 한다.

#### 경주자동차그룹 
- 자동차들에게 경주를 명령한다.(o)

**자동차**
- 자동차는 Engine Output에 따라 움직이거나 움직이지 않는다. (o)
- 랜덤값이 4 이상이면 움직이고, 그렇지 않으면 멈춘다 --> Engine 으로 위임 (o)

**도우미**
- 랜덤값을 0에서 9사이로 반환한다 (o)
-> 랜덤값을 0 이상 매개변수 사이로 반환한다.
-> 고민) Random 클래스 자체적으로 0이하가 들어올 때 RuntimeException. RandomUtil에서 처리를 해줘야할까?


## 질문사항 
 
테스트의 범위 -> RacingCars 테스트 
Q. 경기 후 반환되는 스냅샷이 제대로 저장되어있는지까지 확인하면 
```java
assertAll(
                () -> assertThat(snapshot.getCarSnapShots().get(0)).isEqualToComparingFieldByField(new CarSnapShot(1)),
                () -> assertThat(snapshot.getCarSnapShots().get(1)).isEqualToComparingFieldByField(new CarSnapShot(0)),
                () -> assertThat(snapshot.getCarSnapShots().get(2)).isEqualToComparingFieldByField(new CarSnapShot(1))
);
```


위와같이 매우 더러워짐.

RacingCars는 경기 후 RacingGameShot을 반환하는 책임이 있는데, 그럼 테스트의 범위는? 
일단 현 시점에서 모든 자동차들의 기록을 반환한다는 의미로 사이즈체크만 ,, 
제대로 저장하는지는 RacingGameSnapshot 테스트에서만 해도 되는건가 ,, --> RacingGameSnapshot은 단순 List만물고 검증로직도 없는 일급컬렉션이라
테스트를 해도 List 테스트에 불과한 것 같다. 그럼 그냥 믿고써야하는건가, 명시적으로 해야하는건가 .. 
