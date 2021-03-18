# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## STEP 3 자동차 경주 구현실습
###1.구현기능 기술
* 사용자는 InputView 를 통해 자동차 대수와 시도횟수를 입력한다.
* 입력한 데이터는 Request 객체에 담겨 Controller 클래스로 전달된다.
* Controller 클래스는 CarRacingService 클래스를 통해 경기 결과를 전달받는다.
* CarRacingService 클래스는 RacingResult 클래스를 생성해 Car 인스턴스들의 경기를 진행하고, 성적산출 결과를 반환한다.

###2.구현대상 소스
* [Frontend]
  * CarRacingApplication : 유저의 입력과 출력이 일어나는 Frontend 소스
  * InputView : 유저의 값 입력을 담당하는 입력 UI 소스
  * OutputView : API 실행결과를 그래피컬하게 출력해주는 출력 UI 소스
* [Presentation Layer]
  * CarRacingController : 자동차 경주 전 과정을 처리할 Controller 클래스
  * CarRacingRequest : 유저의 경주 시작관련 입력값을 저장하고 있는 DTO 클래스
* [Service Layer]
  * CarRacingService : 자동차 경주를 진행하고 성적을 산출하기 위한 Application Service 클래스
  * CarRacing : 자동차 경주의 비즈니스 로직을 가지고 있는 도메인 클래스
  * RacingResult : CarRacingService 처리결과가 담긴 응답객체
  * RacingScore : 자동차의 한 라운드 경주성적을 저장하고 있는 클래스
  * RoundResult : 참가한 자동차들의 한 라운드별 경주성적 목록을 저장하고 있는 클래스
* [domain Layer]
  * Car : 자동차 경주에 참여한 차 한대를 나타내는 Entity 클래스
  * Cars : 참가한 자동차들의 모임 클래스
  * Winners : 자동차 경주 승자들의 모임 클래스 
  * Engine : 자동차의 움직임을 결정하기 위한 클래스
* [common]
  * CarRacingConstant : 업무 처리에 필요한 상수모음