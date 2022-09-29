# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# STEP 4 : 자동차 경주 (우승자)

## STEP 3 리팩토링 요구사항
* [x] 동료들이 리뷰하기 좋은 개발 단위로 commit 하기
* [x] Random값 인터페이스로 추상화해서 실구현체와 테스트구현체로 나눠 테스트 진행하기
* [x] 자체적으로 결과 string을 생성하지말고 resultView에서 자동차의 위치만 받아서 결과 출력
* [x] util -> 원시값 포장 사용하기

## 기능 요구사항
* 각 자동차에 이름을 부여할 수 있다.
* 자동차 이름은 5자를 초과할 수 없다.
* 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분한다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

* Car
  * [ ] 각 자동차에 이름 필드를 부여
  * [ ] 이름필드에 대해 5자 제한 (원시값 보장, validation?)
  * [ ] 
* ResultView
  * 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
    * [ ] Car에서 이름을 꺼내와 출력한다.
* InputView
  * [ ] 자동차 이름은 ','를 기준으로 구분한다.
* RacingGame
  * [ ] 자동차 경주 게임의 우승자를 판단한다.
* RacingRecord
  * [ ] 자동차 경주 게임의 우승자를 저장한다.
## 요구사항 적용

