# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## To-Do
* 패키지 생성 : view(InputView, ResultView), domain(CarFactory, Car, RacingGame, RacingMain), util(RandomUtil)
* Scanner를 이용한 자동차 대수 입력 - InputView
* Scanner를 이용한 시도 횟수 입력 - InputView
* Car 객체들을 관리하는 List 생성 (리스트 크기 = 입력한 자동차 대수) - CarFactory
* Car 객체 생성 (field : position(현재 위치이자 전진 횟수)) - Car
* Random을 이용한 랜덤값 추출 - RandomUtil
* 랜덤 값이 4 이상인지를 기준으로 전진/정지 결정 - Car
* 전진일 경우 Car 객체의 location 값을 1 증가 - Car
* 경주 결과 출력 - ResultView