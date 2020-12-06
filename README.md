# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

---
### 모델링
##### InputView
* 자동차 수 입력
* 시도한 횟수 입력

##### RacingCarGame
* 입력한 자동차 수만큼 게임 시작

##### RandomMove
* 0~9 생성한 random 값들 중에서 4이상일 경우 이동 -> true

##### Car
* 이동할 때마다 position(위치) 증가

##### Cars
* 모든 자동차(Car)들 이동

##### GameResult
* 한 게임 끝나고 결과(모든 자동차 위치) 저장

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
