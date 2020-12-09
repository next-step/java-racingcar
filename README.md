# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

### STEP2 문자열 계산기
---------
* 덧셈
* 뺄셈
* 나누기
    * 0으로 나눌 경우 "0으로 나눌 수 없습니다."
    * 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정
* 곱하기
* 입력 값이 없을 경우, "입력 값이 없습니다."
* 사칙 연산이 아닌 경우, "사칙연산 기호가 올바르지 않습니다."
* 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정
* 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정
    * 공백이 없을 경우, "공백 구분자가 없습니다."
* 입력 문자열의 포맷 매칭 공백구분으로 나눈 문자열 배열의 길이가 짝수이거나 처음 인덱스 값과 마지막 인덱스 값이
숫자가 아닌 경우 "입력값의 포맷이 맞지않습니다."

### 자동차 경주 게임 3단계
-------------

주어진 횟수동안 n대의 자동차는 전진 또는 멈출 수 있다.
사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
전진하는 조건은 0~9범위 내에서4 이상일 경우이다


* 0~9 범위내에서 4 이상일 경우 전진 +1 
    * 0~9 범위가 아닐 경우, "전진 조건 범위를 초과하였습니다."
* n개 만큼 자동차 생성
    * 1보다 작을 경우, "최소 자동차 1대 이상입니다."
* 주어진 횟수동안 랜덤 숫자 생성
    * 주어진 횟수가 1보다 작을 경우, "주어진 횟수는 최소 1번입니다."
* 전진 횟수만큼 - 출력 
