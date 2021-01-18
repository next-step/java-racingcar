# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 구현할 기능 목록
 - 사칙연산 하는 static 메서드를 보유하고 있는 util class
  - 덧셈
  - 뺄셈
  - 나눗셈
  - 곱셈
 - 메인으로 동작하는 문자열 계산기 class
  - 사칙연산 입력 받는 기능 - IllegalArgumentException throw 필요
  - util class의 static method를 이용해 사칙 연산을 하는 기능
  - 연산 결과를 반환하는 기능
