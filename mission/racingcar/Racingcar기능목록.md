🚗 RacingCar 
========================
초간단 자동차 경주 게임 구현
--------------------------

### 📌 목차
- [요구 사항](#요구-사항)
- [기능 구현 목록](#기능-구현-목록)
- [기능 구현 코드](#기능-구현-코드)

---

### 요구 사항 
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
**input**
- [x] 이름 입력 메소드 : `Input#name`
- [x] 게임 횟수값 입력 클래스 :  `Input#gameCount`

**Car**
- [x] 자동차 생성자(name, position 값을 가짐): `Car#Car`
- [x] 자동차 자기 생성자(position 초기값을 0 설정): `Car#Car`
- [x] 이름 길이 검증(길이가 5이상은 에러) :  `Car#validateName`
- [x] 전진하기 : `Car#go`
- [ ] 위치값 가지고 있는지 물어보기 : `Car#isInposition`
- [ ] 위치값 크기 물어보기 : `Car#isposition`

**Ready**
- [x] 이름 배열 이용해서 경주용 자동차 목록 만들기 : `Ready#createCars`
- [x] 이름 값 이용해서 경주용 자동차 목록 만들기 : `Ready#createCars`
- [x] Name input값 `,`로 나누기 :  `Ready#splitName`

**Stadium**
- [x] 경기장 생성(자동차 목록, 게임 횟수 값을 가짐): `Stadium#Stadium`
- [x] 난수 생성하기 : `Stadium#drawNumber`
- [x] 자동차 경주하기 : `Stadium#playRace`
- [x] 자동차 경주 중간 과정 출력하기 : `Stadium#goingProcess`
- [ ] 우승자를 발표하기(자동차 경주 결과 받기) : `Stadium#winnerIS`

**Application**
```text
1. input : 이름, 게임 횟수 입력받기
2. Car : 자동차 생성하기
3. Ready : 자동차 목록 생성하기
4. Stadium : 경기장 생성하기
5. Stadium.playRace : 게임하기
6. Award.winnerIs : 시상식(우승자 발표)
```

#### test 클래스
**Car**
- [x] 자동차 생성자 테스트: `CarTest#createCarTest`
- [x] 이름길이 검증하면서 car 생성 테스트 : `CarTest#createCarWithValidationTest`
- [x] 전진 테스트 : `CarTest#goTest`
- [x] 정지 테스트 : `CarTest#stopTest`

**Ready**
- [x] 이름 배열을 이용해서 자동차 목록 만들기 테스트 : ` ReadyTest#createCarsWithNameArrayTest`
- [x] input 이용해서 자동차 목록 만들기 테스트 : ` ReadyTest#createCarsWithInputTest`

---

### 기능 구현 코드
- [mian 클래스][M]
- [test 클래스][T]

---

[M]:https://github.com/Data-ssung/java-racingcar/tree/ssungwork/src/main/java/racingCar
[T]:https://github.com/Data-ssung/java-racingcar/tree/ssungwork/src/test/java/racingCar
