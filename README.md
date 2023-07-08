# 문자열 덧셈 계산기
## todo
- 문자열 계산
  - [x] 빈 문자열 혹은 null 문자열을 계산하는 경우 0을 반환한다
  - [x] 문자열을 쉼표 또는 콜론으로 구분해서 각 숫자의 합을 반환한다
  - [x] 커스텀 구분자로 문자열을 주는 경우 해당 구분자로 구분된 각 숫자의 합을 반환한다
- 문자열 구분
  - [x] 커스텀 구분자 문자열을 사용하는 경우를 구분할 수 있다
- 문자열 검증
  - [x] 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 이 발생한다

# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## todo
- 입력값 검증
  - [x] 자동차들 이름 입력은 쉼표로 구분되며, 각 자동차의 이름은 양쪽 공백을 제거하고 5자 이하여야 한다
  - [x] 시도할 횟수의 입력은 양쪽 공백을 제거했을 때 양수여야 한다
  - [ ] 입력으로 잘못된 값이 주어진 경우 재입력을 요청한다
- 자동차
  - [x] 자동차는 이름을 가진다
  - [x] 자동차는 주어진 값이 4이상이면 한 칸 전진, 3이하일 경우 정지해야 한다
- 자동차 목록
  - [x] 가장 많이 전진한 자동차가 우승한다 (우승자는 한명 이상일 수 있다)
