# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 계산기
- TDD 목록
  - Null인 경우 IllegalArgumentException
  - 사칙연산 기호가 아닌 경우 IllegalArgumentException
  - 덧셈
  - 뺄셈
  - 나눗셈
  - 곱셈
  - 구분자 split 하기
  - 사칙 연산을 모두 포함하는 기능

## 자동차 경주 1단계
- TDD 목록
  - 4이상일 경우엔 전진
  - 4이하인 경우엔 count 증가 X
  - ~~숫자가 아닌 경우 IllegalArgumentException~~
  - 0에서 9사이의 랜덤값을 가져온다.
  
## 자동차 경주 2단계
- TDD 목록
  - 우승자를 나타낸다
  - 자동차 입력형태가 없을경우 NullPointException
  - 컴마 형태의 구분자 이용해서 자동차 이름을 구분한다.
- 보완해야 할 사항
  - 경기 진행 횟수 만큼 경기 진행 결과 보이기
  - 반복문을 Stream 형태로 구현할 방법은 없나