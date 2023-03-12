# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 구현 목록
## InputView
* 자동차 이름 반환하기
* 시도횟수 반환하기
## RacingPrinter
* 달리는 상태 출력하기
* 우승자 출력하기
## RacingCarPrinter
* 경주 자동차 달리는 상태 표시
## RacingCar
* 전진
* 전진상태 보여주기
* 비교
* 제친 자동차 수 보여주기
* 이름 알려주기
## RacingRandom
* 10배수 랜덤 함수
## Racing
* 모든 자동차 전진
* 특정번호 자동차만 전진
* 우승자 선택하기
## RacingMain
* main 함수 - input을 받아 처리하기