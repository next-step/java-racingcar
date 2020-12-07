# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereviewi

## Step1 요구사항
### String 클래스에 대한 학습 테스트
- 요구사항 1
    - [X] "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    - [X] "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
    
- 요구사항 2
    - [X] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.

- 요구사항 3
    - [X] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    - [X] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    - [X] JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
    
### Set Collection에 대한 학습 테스트
- 다음과 같은 Set 데이터가 주어졌을 때 요구사항을 만족해야 한다.
```java
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    
    // Test Case 구현
}
```
- 요구사항 1
    - [X] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
    
- 요구사항 2
    - [X] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
    - 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
    - JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.

    
- 요구사항 3
    - [X] 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
    - 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.

## Step2 문자열 사칙 연산 계산기 구현

### 요구사항
- `문자열 계산기(StringCalculator)`
    - 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
    - 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
    - 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
    - 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
    - [예] 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
    - [X] 문자열을 판독하고 계산할 수 있다.

- `판독기(Reader)`
    - `계산식(Expression)`을 만드는 역할을 한다.
    - [X] 문자열로 `계산식(Expression)`을 만든다.
    
- `계산식(Expression)`
    - 사칙연산을 수행할 수 있는 식을 의미한다.
    - [X] 계산식의 결과를 얻을 수 있다.
    
- `연산자(Operator)`
    - 2개의 수를 연산하는 역할을 한다.
    - [X] 2개의 `숫자(Number)`를 연산할 수 있다.
    - [X] 특정 연산자를 찾을 수 있다.
    - [X] 조건에 맞는 연산자가 없다면 예외처리 한다.

- `숫자(Number)`
    - [X] 문자열을 통해 만들 수 있다.
    - [X] 숫자가 아닌 문자열 일 경우 예외처리 한다.
    
## Step3 자동차 경주

### 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
    
### 실행 결과
- 위 요구사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.  
    ```text
    자동차 대수는 몇 대 인가요?
    3
    시도할 회수는 몇 회 인가요?
    5
    
    실행 결과
    -
    -
    -
    
    --
    -
    --
    
    ---
    --
    ---
    
    ----
    ---
    ----
    
    ----
    ----
    -----
    ```
  
### 요구사항

- `자동차경주(RacingGame)`
    - 주어진 판 수 만큼 `이동 규칙(Moveable)`에 따라 게임을 진행하는 역할을 한다.
    - [X] 게임을 진행하고 `게임 보고서(GameReport)`를 만들 수 있다.
    
- `자동차 공장(CarFactory)`
    - 요구사항에 맞춰 자동차를 만드는 역할을 합니다.
    - [X] `자동차들(Cars)` 을 만들 수 있다.
     
- `이동 규칙(MoveAble)`
    - 이동 가능의 유무를 결정하는 역할.
    - [X] 이동 가능 여부를 확인할 수 있다.
    
- `판들(Rounds)`
    - 자동차 경주에서 판 수를 나타내며 0 이상의 하나의 숫자를 의미한다. 
    - [X] `게임 보고서(GameReport)`를 만들 수 있다.

- `자동차들(Cars)`
    - [X] 각 판마다 `자동차(Car)`들을 움직일 수 있다.
    - [X] `판 보고서(RoundReport)`를 만들 수 있다.
    
- `자동차(Car)`
    - [X] `이동 규칙(Moveable)`의 결과로 움직일 수 있다.
    - [X] `자동차 보고서(CarReport)`를 만들 수 있다.
    
- ~~자동차 식별자(CarIndex)~~
     - ~~자동차 식별자는 `자동차(Car)`를 식별하는 하나의 숫자를 의미한다.~~

- `자동차 이름(CarName)`
    - [X] 자동차 이름은 5자를 초과할 수 없다.   
    
- `위치(Location)`
    - `자동차(Car)`의 위치 정보를 나타내는 하나의 숫자를 의미한다.
    - [X] 0과 양수를 허용한다.
    - [X] 음수 값은 허용하지 않는다.
    - [X] 위치를 증가시킬 수 있다.
    
- `게임 보고서(GameReport)`
    - `판 보고서(RoundReport)`에 대한 통계를 나타낸다.
    - [X] 게임의 우승자들을 구할 수 있다.
    
- `판 보고서(RoundReport)`
    - 각각의 판 별 `자동차 보고서(CarReport)`에 대한 통계를 나타낸다.
    - [X] 판의 우승자들을 구할 수 있다.
    
- `자동차 보고서(CarReport)`
    - `자동차(Car)`에 대한 상태 정보를 가지고 있는 보고서를 의미한다.
    
    
- `넥스트스탭 자동차 공장(NextStepCarFactory)`
    - [X] ',' 구분자로 자동차를 만들 수 있습니다.
    
- `넥스트스탭 이동 전략(NextStepMoveable)`
    - 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우 이동한다.
    
    
## Step4 자동차 경주(우승자)

### 기능 요구사항
- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
