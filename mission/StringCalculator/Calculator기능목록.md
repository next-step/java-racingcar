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
##### main 클래스
- [x] input 받기 : `Input#inputValue`
- 사용자 입출력에 관한 테스트는 어려움 
    => 로직위주의 테스트 해보기
- [ ] 빈값 (null 값 or 공백) 판단하기 : `Input#checkBlank`  
- [ ] 빈값 예외 처리 : `Input#blankErrorException`
- [ ] input 값 `" "`기준으로 split하기 : `Input#Splitter` 
- [ ] 사칙연산 기능(덧셈, 뺄셈, 곱셈, 나눗셈) 생성 : `Calculator#add/sub(subtract)/mul(multiply)/div(divide)` 
- [ ] 나누기 연산 에러 예외 처리 ex) 0으로는 나눌 수 없음 
: `Calculator#divideErrorException` 
- [ ] 사칙연산 부호 딕셔너리 : `Calculator#operator` 
- [ ] 사칙연산 부호 평가(if 구문 하나만 사용) : `Calculator#operatorEvaluation`
- [ ] input 값 사칙연산 수행(if 구문 하나만 사용) : `Calculator#calculation`

##### test 클래스
- [ ] 빈값 테스트 : `InputTest#checkBlank`  
- [ ] 빈값 예외 처리 테스트 : `InputTest#blankErrorException`
- [ ] input 값 `" "`기준으로 split 테스트 : `InputTest#Splitter` 
- [ ] 사칙연산 기능 테스트 : `CalculatorTest#add/sub(subtract)/mul(multiply)/div(divide)` 
- [ ] 나누기 연산 에러 예외 처리 테스트 : `CalculatorTest#divideErrorException`  
- [ ] 사칙연산 부호 평가 `CalculatorTest#operatorEvaluation`
- [ ] input 값 사칙연산 수행: `CalculatorTest#calculation`

<br>

### 기능 구현
- [mian 클래스][M]
- [test 클래스][T]

[M]:https://github.com/Data-ssung/java-racingcar/tree/ssungwork/src/main/java/calculaor
[T]:https://github.com/Data-ssung/java-racingcar/tree/ssungwork/src/test/java/calculaorTest

