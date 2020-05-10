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
- 연산자
    - [ ] String을 인자로 입력받아서 연산자 Enum 타입으로 전환
    - [ ] 연산자로 바꿀 수 없는 인자 예외 처리
- 계산기
    - [ ] 입력받은 문자열 인자를 입력값 파싱을 통해 리스트로 전환
    - [ ] 리스트를 순회하면서 계산 대상은 숫자 타입으로, 연산 대상은 연산 타입으로 전환
    - [ ] 주어진 숫자와 연산을 순차적으로 실행
