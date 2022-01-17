# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구 사항

사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기. 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.

## 기능 구현 사항

- [ ] 입력 받기 (Expression.getUserInput())
- [ ] 연산 (Calculator)
    - [ ] 덧셈(.add())
    - [ ] 뺄셈(.sub())
    - [ ] 곱셈(.mul())
    - [ ] 나눗셈(.div())
- [ ] 입력 검증 (Validator)
    - [ ] 빈 문자열 -> IllegalArgumentException
    - [ ] 사칙 연산 기호가 아니면 -> IllegalArgumentException
    - [ ] 입력 형식 (number op number op number ...) 검증 ->IllegalArgumentException throw

입력값이 null이거나 빈 공백 문자일 경우 ç throw 사칙연산 기 호가 아닌 경우 IllegalArgumentException
throw 사칙 연산을 모두 포함하는 기능 구현 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다. 반복적인 패턴을 찾아
반복문으로 구현한다.