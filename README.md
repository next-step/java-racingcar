# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

### [STEP2] 문자열 계산기 기능목록 
* 사칙연산 수행
  * '숫자문자 연산기호 숫자문자' 형태로 3개의 문자열이 들어오면 해당 사칙연산의 결과를 반환한다. (덧셈, 뺄셈, 곱셈, 나눗셈)
  * 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
  * 연산기호가 사칙연산 기호가 아닌 경우 IIllegalArgumentException throw

* 문자열 파싱
  * 문자열 " " 으로 split
  * split 된 문자열 '숫자문자 연산기호 숫자문자' 형태로 사칙연산 계산 호출