## 문자열 사칙 연산 계산기
## 요구사항
1. 사용자가 입력한 문자열 값에 따라 사칙연산을 수행하는 계산기 구현
2. 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다  
3. 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
4. 입력한 순서에 따라 계산된다.

## 기능 목록
1. 덧셈
2. 뺄셈
3. 곱셈
4. 나눗셈
5. 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
6. 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
7. 사칙 연산을 모두 포함하는 기능 구현

# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 기능  요구 사항
1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
2. 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
3. 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
4. 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
5. 자동차 이름을 부여할 수 있다. (5자 초과 불가, 쉼 구분)

## 기능 정의
1. 자동차 대수, 진행할 횟수를 입력 받는 기능
2. 전진 여부를 구하는 기능
3. 자동차의 이름과 상태를 화면에 출력하는 기능
4. 자동차의 이름을 입력하는 기능
5. 우승한 자동차의 이름을 출력하는 기능




## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)