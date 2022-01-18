# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

# 문자열 계산기 🧮
## 기능 구현 목록
### 결정할 것
1. 소수점 입력 받는 것 허용할 것인지? -> 안하는게 편하겠다~
2. 입력 - Scanner ? / BufferedReader

- [ ] 사용자입력 - Expression
  - [ ] 입력값을 숫자와 연산기호로 나누어 관리한다.
    - [ ] 문자열 내에 있는 공백을 모두 지운다. - Expression#deleteWhiteSpace
    - [ ] 숫자와 문자로 나누어 List로 관리한다. - Expression#seperateNumbersOperators
  - [ ] 예외 처리 : 예외처리된 이유 출력 & 다시 입력하라는 안내 문구 출력 Validator
    - [ ] 정규표현식으로 잡을 것들 - Validator#validateException
      - [ ] 입력값이 null이거나 빈 공백 문자일 경우
      - [ ] 사칙연산 기호가 아닌 것이 들어가 있을 경우 (문자, %, ...)
      - [ ] 숫자 다음 사칙연산 기호가 아닌 다른 숫자가 오는 경우 (e.g. 33 * 1 23) 
      - [ ] 사칙연산 기호 다음 기호가 또 나오는 경우 (e.g. 33 + + 1) 
      - [ ] 사칙연산 기호가 제일 앞이나 제일 뒤에 올 경우
    - [ ] 예외에 해당된다면, 올바르지 못한 이유 & 사용자 입력 다시 수행 Validator#printCause
- [ ] 사칙연산 - Operation
    - [ ] 초기값 설정 - Opertaion#setInitiateNumber
    - [ ] 덧셈 - Operation#add / addition
    - [ ] 뺄셈 - Operation#sub / subtraction
    - [ ] 곱셈 - Operation#mul / multiplication
    - [ ] 나눗셈 - Operation#div / division
      - [ ] 0으로 나눌 경우(예외 처리를 해아할 지, 사칙연산에서 불가능한 수라고 나타내야할 지) - #validateDivideZero
    - [ ] 계산결과 출력 - Operation#resultOfCalculate

