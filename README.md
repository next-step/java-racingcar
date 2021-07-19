# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

### 기능 분리

1. 문자열을 공백 단위로 분리한다.
2. 분리된 문자열이 숫자인지, 기호인지 판단한다.
3. 입력값 null, 공백 체크
4. 숫자, 사칙연산 기호 validation
5. 사칙연산기호(짝수 인덱스)를 기준으로 연산을 수행한다.