# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


# 3단계 자동차 경주 게임
## 기능 정리
- [x] 주어진 횟수 동안 n대의 자동차는 전진 or 멈춤
- [x] 사용자로부터 자동차 수로 자동차 이동 횟수를 받는다.
- [x] 전진 조건은 0~9 사이의 숫자를 random하게 구한다.
    - [x] random 값이 4이상일 경우 전진
    - [x] random 값이 4미만일 경우 제자리
- [x] 자동차의 상태를 화면에 출력한다.
- [x] 어느 시점에 출력할 것인지에 대한 제약은 없다.

### Car 상세 정리
- [x] 0에서 9사이의 숫자를 랜덤하게 뽑는다.
- [x] 자동차가 전진할 수 있는지 확인한다.
- [x] 자동차를 전진한다.
- [x] 내 차례에 세가지를 한 번에 동작시킨다.
- [x] 자동차의 현재 위치를 찾는다.

### RacingGame 상세 정리
- [x] 사용자가 입력한 자동차 수만큼 자동차 리스트를 만든다.
- [x] 한 차례가 지날 때마다 한 턴을 실행시킨다.
- [x] 모든 차의 현재 위치를 업데이트 해준다.

### InputView
- [x] 사용자로부터 자동차 수로 자동차 이동 횟수를 받는다.

### ResultView
- [x] 결과를 출력할 수 있다.