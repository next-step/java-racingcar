# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 자동차 경주 게임 구현 기능
* input param) numberOfCars(자동차대수), numberOfGames(게임횟수)
1) randomNumber 추출
2) 이동여부 판단
   - randomNumber >= 4 :전진(true)
   - randomNumber <  4 :멈춤(false)
3) 이동거리 계산(전진일 경우 기존 거리 +1)
4) 이동거리 -로 출력