# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## Step2. 문자열 계산기
### 요구사항
- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### Todo List
- 입력값 파싱
    - [X] 입력값 유효성 검증(null, 빈 문자열 금지)
    - [X] 공백을 구분자로 입력값 구분 후 리스트 반환
    - [X] parse 수행 전 무조건 유효성 검증 수행하도록 구현
- 숫자
    - [X] String을 인자로 받아서 Int 타입으로 전환
    - [X] Int 타입 변경 불가능한 인자 예외 처리 (내장 parsetInt 정적 메소드가 알아서 처리해줌)
    - [X] 같은 타입의 객체와 덧셈 기능 지원
    - [X] 같은 타입의 객체와 뺄셈 기능 지원
    - [X] 같은 타입의 객체와 곱셈 기능 지원
    - [X] 같은 타입의 객체와 나눗셈 기능 지원
    - [X] 0으로 나누는 경우 에러 처리
- 사칙연산 구분
    - [X] 사칙연산 enum 생성
    - [X] 별도 클래스에서 사칙연산 구분 후 반환
- 계산기
    - [X] 단항 연산에 대한 사칙 연산 수행
    - [X] 다항 연산에 대한 사칙 연산 수행
    - [ ] String 연산자에 따라 알맞는 Operator 고르는 책임을 위임
- OperatorSelector
    - [X] 입력된 String 연산자에 따라 알맞는 Operator 반환
    - [X] 연산자 외의 문자열 입력 시 IllegalArgument 예외 발생
- Operator
    - [X] 사칙연산을 enum 타입으로 분리
    - [X] Operator enum에서 동작을 모두 갖도록 덧셈 구현
    - [X] 같은 방식으로뺄셈, 나눗셈, 곱셈 구현
- 리뷰 반영(enum 활용도 높이기)
    - [X] Number 객체의 계산 책임을 모두 Operator enum으로 이관
    - [X] OperatorSelector 객체의 책임도 Operator enum으로 이관
    - [X] Runner 클래스에서 OperatorSelector 대신 Operator enum으로 책임 이관
- 리뷰 반영(String까지 enum화 시키기)
    - [X] Operator enum에 String operator 속성 추가
    - [ ] Operator select 함수 if 걷어내기
