🚗 RacingCar 
========================
초간단 자동차 경주 게임 구현
--------------------------

### 📌 목차
- [구현 기능 정리](#구현-기능-정리)
- [기능 구현 목록](#기능-구현-목록)
- [기능 구현 코드](#기능-구현-코드)

---

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

---

### 기능 구현 목록
#### main 클래스
- Input
- [x] 자동차 이름 입력 받기(System in) : `Input#carName`
- [x] 경기 수 입력 받기(System in) : `Input#gameNumber`
- Ready
- [x] 자동차 이름 `,`기준으로 분리하기 : 
`Ready#splitNameByComma`
- [x] 숫자가 5가 넘는지 확인하기 : `Ready#isGreaterThan`
- [x] 자동차 이름 길이가 5넘는지 확인하기 (예외처리 : 자동차 이름의 길이가 5이상이면 에러 `IllegalArgumentException`에러 발생) : `Ready#checkNameLength`
- [x] 게임 참가자(자동차) 리스트 만들기 (예외처리 : 자동차 이름의 길이가 5이상이면 다시 입력받기) : `Ready#createPlayerListBycarName`
- [x] 자동차 경주 점수판 만들기 : `Ready#createScoreTableByPlayerList`
- Function
- [x] 랜덤 수 뽑기 `Function#drawNumber`
- [x] 자동차 전진(4이상이면) : `Function#moveAble` 
- [x] 자동차 전진하면 점수(`-`) 얻기: `Function#getScore`
- Play
- [ ] 1회 게임하기 : `Paly#OneRoundGame`
- [ ] gameNumber만큼 게임하기 : `Paly#Game`
- Award
- [ ] value 값 길이 중 가장 큰 값 비교 : 
`Awards#compareScore`
- [ ] 경기 결과 담기(길이) : `Awards#scoreTable`
- [ ] 최종 우승자 결과 출력 : `Awards#isWinner`

#### test 클래스
- ReadyTest
- [x] `,`기준으로 분리 테스트: `ReadyTest#testSplitNameByComma`
- [x] 숫자가 5 초과하는 경우 테스트 : `ReadyTest#testIsGreaterThanFive`
- [x] 숫자가 5 이하인 경우 테스트 : `ReadyTest#testIsNotMoreThanFive`
- [x] 자동차 이름 길이가 5 이하인 경우 테스트(정상케이스) : `ReadyTest#testNameLengthIsNotMoreThanFive`
- [x] 자동차 이름 길이가 5 초과인 경우 테스트(예외 케이스) : `ReadyTest#testNameLengthIsGreaterThanFive`
- [x] 자동차 리스트 생성 테스트 (정상 케이스, 이름 5자 이하) : `Ready#testCreatePlayerListBycarName`
- [x] 자동차 리스트 생성 실패 테스트 (예외 케이스, 이름 5자 초과) : `Ready#testExceptionCreatePlayerListBycarName`
- [x] 자동차 경주 점수판 만들기 : `ReadyTest#testCreateScoreTableByPlayerList`
- FunctionTest
- [x] 자동차 전진(4이상이면) : `functionTest#testMoveAble` 
- [x] 자동차 전진 실패(4미만이면) : `functionTest#testNotMoveAble`
- [x] 자동차 전진하면 점수(`-`) 얻기 테스트 : `function#testGetScore`
- [x] 자동차 점수 얻기`""` 실패 테스트 : `function#testNotGetScore`
- Play
- [ ] 자동차 게임하기: `PalyTest#testPalygame`
- Award
- [ ] value 값 길이 중 가장 큰 값 비교 : `AwardsTest#compareScoreTest`
- [ ] 경기 결과 담기(길이) : `AwardsTest#scoreTableTest`
- [ ] 최종 우승자 결과 출력 : `AwardsTest#isWinnerTest`

---

### 기능 구현 코드
- [mian 클래스][M]
- [test 클래스][T]

---

[M]:https://github.com/Data-ssung/java-racingcar/tree/ssungwork/src/main/java/racingCar
[T]:https://github.com/Data-ssung/java-racingcar/tree/ssungwork/src/test/java/racingCar
