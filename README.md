# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.
* 
## Step1 자동차 경주
 - [x] 자동차는 이름을 가질 수 있다. - Car
 - [x] 자동차 이름의 길이가 5글자를 넘으면 예외가 발생한다.- Car
 - [x] 자동차의 현재 위치는 0이다. - Car
 - [x] 자동차의 현재 위치를 알 수 있다.- Car
 - [x] 자동차가 이동한다.- Car
 - [x] 자동차가 정지한다.- Car
 - [x] 자도차들 중에서 가장 멀리 간 위치가 어디인지 알 수 있다. - RacingGame
 - [x] 특정 위치에 해당하는 자동차들을 알 수 있다. - RacingGame
 - [x] 자동차가 한 대가 우승한 경우 - Winner
 - [x] 자동차 여러 대가 우승한 경우 - Winner

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
  (https://github.com/next-step/nextstep-docs/tree/master/codereview)
* 
## Step2 (2단계 - 자동차 경주 리팩터링)
* 프로그래밍 요구 사항
* 핵심 비즈니스 로직을 가지는 객체를 domain 패키지, UI 관련한 객체를 view 패키지에 구현한다.
* MVC 패턴 기반으로 리팩터링해 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현한다.
 - [x] MVC 패턴 기반으로 리팩터링
 - [x] domain 패키지 분리&구현하기
 - [x] view 패키지 분리&구현하기
 - [x] domain 패키지는 view 패키지 객체에 의존하지 않도록 구성하기
 - [x] 상수값화 하기 constant
 - [x] 분리후 성능검토 및 더 리팩토링 할수있는 부분 찾기 