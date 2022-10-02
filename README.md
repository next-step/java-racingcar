# 자동차 경주 게임

## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

# 기능 목록

## model

* Car 클래스 구현

  * Car 누적 거리를 가진다 (distance)
  * 전진 시 누적 거리에 더한다.

* Racing 클래스 구현

  * Car List 개수와 레이싱 횟수를 인자로 받는다.
  * 레이싱 횟수 마다 Car 의 distance 를 출력한다.

## util

* RandomUtil 클래스 구현

  * 랜덤 값을 계산하여 true / false 로 반환한다.

## view

- ResultView 클래스 : UI 로직 클래스