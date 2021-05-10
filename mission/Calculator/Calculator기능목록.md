StringCalculator
========================
문자열 사칙 연산 계산기 구현
--------------------------

### 구현 기능 정리 
#### 요구사항
- 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
- 사칙 연산의 계산 우선순위가 아닌 `입력 값에 따라 계산 순서가 결정`된다. 
- 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

#### 기능 구현 목록
- input 객체 : `Input#inputValue`
- 입출력에 관한 테스트는 어려움
- 다른 객체와 로직위주의 테스트 실행
##### main 클래스
- [x] 빈값 (null 값 or 공백) 판단하기 : `Input#checkBlank`  
- [x] input 값 `" "`기준으로 split하기 : `Input#splitter` 
- [x] 빈값을 받으면 예외처리(`IllegalArgumentException`), 빈값이 아니면 isSplit 메소드 사용: `Input#isSplit`
- [x] 사칙연산 기능(덧셈, 뺄셈, 곱셈, 나눗셈) 생성 : `Operator#add/sub(subtract)/mul(multiply)/div(divide)` 
- [x] 나누기 연산 에러 예외 처리(`IllegalArgumentException`) ex) 0으로는 나눌 수 없음
: `Operator#div` 
- [x] 문자형을 숫자형으로 변환 : `Evaluation#ConvertToNumber`
- [x] 사칙연산 부호 평가하기 : `Evaluation#operatorEvaluation`
- [x] 사칙연산 부호 예외 처리(`IllegalArgumentException`) : `Evaluation#operatorException`
- [ ] input 값 사칙연산 수행: `Calculation#calculation`

##### test 클래스
- [x] 빈값 테스트 : `Input#checkBlankTest`  
- " "은 통과하는데, null 값은 통과 안 됨
- [x] input 값 `" "`기준으로 split 테스트 : `InputTest#splitterTest` 
- [x] isSplit 테스트할 때, 빈값 예외 처리 테스트 : `InputTest#isSplitTest`
- [x] 사칙연산 기능 테스트 : `OperatorTest#addTest/subTest/mulTest/divTest`
- [X] 나누기 예외 상황 테스트 `OperatorTest#divExceptionTest`  
- [x] 숫자형 변환 테스트 :  `EvaluationTest#ConvertToNumberTest`
- [x] 사칙연산 부호 평가 테스트 `EvaluationTest#operatorEvaluation`
- [x] 사칙연산 부호 예외 처리 테스트: `Evaluation#operatorException`
- [ ] input 값 사칙연산 수행: `Calculation#calculation`

<br>

### 기능 구현
- [mian 클래스][M]
- [test 클래스][T]

[M]:https://github.com/Data-ssung/java-racingcar/tree/ssungwork/src/main/java/calculaor
[T]:https://github.com/Data-ssung/java-racingcar/tree/ssungwork/src/test/java/calculaor

