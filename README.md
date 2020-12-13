# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# Step 4    
- [x] Step 3 리뷰 사항 반영
- [x] 자동차별로 이름 지정 기능
- [x] 전진 결과 출력시 자동차 이름 같이 출력
- [x] 자동차 입력을 쉼표를 기준으로 분리하는 기능
- [x] 우승자 출력 기능


# Step 3
# 기능 요구 사항
- [x] 자동차 전진 기능
- [x] 사용자 입력 기능
- [x] 전진 또는 멈춤 판별 기능
- [x] 자동차의 상태 출력 기능


# Step 2
## 문자열 사칙 연산 계산기 구현
### 기능 요구사항
- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
- 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 기능 분리 힌트
- 테스트할 수 있는 단위로 나누어 구현 목록을 만든다.
- 덧셈
- 뺄셈
- 곱셈
- 나눗셈
- 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- 사칙 연산을 모두 포함하는 기능 구현
- 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
- 반복적인 패턴을 찾아 반복문으로 구현한다.

### 기능 명세
- [x] 덧셈
- [x] 뺄셈
- [x] 곱셈
- [x] 나눗셈
- [x] 입력값의 null 또는 공백 문자 검증
- [x] 입력값의 사칙연산 기호 검증
- [x] 사칙연산 모두 포함하는 기능 


# Step1
## String 클래스에 대한 학습 테스트

### 요구사항 1

- [x] "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.

- [x] "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.

### 요구사항 2

- [x] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.


### 요구사항 3
- [x] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.

- [x] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.

- [x] JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.


## Set Collection에 대한 학습 테스트

### 요구사항 1
- [x] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
### 요구사항 2
- [x] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
- [x] JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.

### 요구사항 3
- [x] 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
- [x] 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.


