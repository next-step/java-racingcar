RacingCar 
========================
초간단 자동차 경주 게임 구현
--------------------------

### 구현 기능 정리 
#### 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. 
- 전진 조건은 0에서 9 사이에서 랜덤 수를 뽑아서 4 이상이다.
- 자동차는 이름을 가지며, 5자를 초과할 수 없다.
- 각 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 매 경기를 진행할 때마다 자동차 이름과 결과를 같이 출력한다. ex) `ssung : --`
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려주며, 우승자는 한 명 이상일 수 있다.

#### 프로그램 요구사항
- indent(인덴트, 들여쓰기) depth는 2까지만 허용한다.
- 3항 연산자를 쓰지 않는다.
- (테스트)모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- (테스트) indent(인덴트, 들여쓰기) depth는 1까지만 허용한다.
- else, switch/case 예약어 허용하지 않는다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.

#### 실행결과
- 3대의 자동차가 2번 움직였을 경우 프로그램을 실행한 결과
```text
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,woni,jun
시도할 횟수는 몇 회인가요?
2

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

최종 우승자: pobi, jun
```

<br>

#### 기능 구현 목록
##### main 클래스
- [ ] 자동차 이름 입력 받기(System in) : `Input#CarName`
- [ ] 경기 수 입력 받기(System in) : `Input#GameNumber`
- [ ] 자동차 이름 `,`기준으로 분리하기 : `CarName#Splitter`
- [ ] 자동차 이름 길이 제한 함수 : `CarName#checkNameLength`
- [ ] 자동차 이름 배열 만들기 자동차 이름 예외 처리(5자이상이면 다시 입력하기) : `CarName#carNameList`
- [ ] 
- [ ] 랜덤 수 뽑기 `Game#drawNumber`
- [ ] 자동차 전진(4이상이면) : `Game#moveAble` 
- [ ] 자동차 전진하면 `-`값 업데이트 : `Game#getScore`
- [ ] 자동차 게임하기, 매 경기 출력하기 : `Paly#gamePlay`
- [ ] value 값 길이 중 가장 큰 값 비교 : `Paly#compareScore`
- [ ] 경기 결과 담기(길이) : `Paly#scoreTable`
- [ ] 최종 우승자 결과 출력 : `Paly#isWinner`

##### test 클래스
- [ ] `,`기준으로 분리 Test : `CarName#SplitterTest`
- [ ] 자동차 이름 길이 제한 기능 Test : `CarName#checkNameLengthTest`
- [ ] 자동차 이름 배열 만들기 자동차 이름 예외 처리(5자이상이면 다시 입력하기) : `CarName#carNameListTest`
- [ ] 
- [ ] 랜덤 수 뽑기 `Game#drawNumber` -> Test 어떻게 하지?
- [ ] 자동차 전진(4이상이면) : `Game#moveAbleTest` 
- [ ] 자동차 전진하면 `-`값 업데이트 테스트 : `Game#getScoreTest`
- [ ] 자동차 게임하기: `Paly#gamePlayTest`
- [ ] value 값 길이 중 가장 큰 값 비교 : `Paly#compareScoreTest`
- [ ] 경기 결과 담기(길이) : `Paly#scoreTableTest`
- [ ] 최종 우승자 결과 출력 : `Paly#isWinnerTest`

<br>

### 기능 구현
- [mian 클래스][M]
- [test 클래스][T]

[M]:https://github.com/Data-ssung/java-racingcar/tree/ssungwork/src/main/java/racingCar
[T]:https://github.com/Data-ssung/java-racingcar/tree/ssungwork/src/test/java/racingCar