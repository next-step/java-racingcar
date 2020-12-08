# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 2단계 - 문자열 계산기 TODO

- [x] 덧셈
- [x] 뺄셈
- [x] 곱셈
- [x] 나눗셈
- [x] 연산자가 1개일 경우 계산하기 예) 3 * 4 = 7
- [x] 입력값 파싱 담당 class 분리
- [x] 연산자가 2개 이상일 경우 계산하기 예) 3 * 4 - 2 = 5
- [x] 입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- [x] 사칙 연산을 모두 포함하는 기능 구현
- [x] 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
- [x] 반복적인 패턴을 찾아 반복문으로 구현한다.
- [x] 연산 순서가 틀린 경우 IllegalArgumentException throw
- [x] 표준 입출력으로 동작하는 application 작성

## 3단계 - 자동차 경주 TODO

- [ ] 자동차 대수 입력
- [ ] 시도 횟수 입력
- [x] 자동차 랜덤 전진하기
- [x] 자동차 위치 조회
- [ ] 자동차 위치(결과) 출력