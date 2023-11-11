# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


---

## 3단계 - 자동차 경주
* commit 1 : UI 로직인 입력값을 전달받는 InputView 클래스 구현
  * abc 같은 문자값을 받을 때 RuntimeException 을 발생시킵니다.
  * 3.5 와 같은 소수 형태의 문자값을 받을 때 RuntimeException 을 발생시킵니다.
  * -5 와 같은 음수 형태의 문자값을 받을 때 RuntimeException 을 발생시킵니다.


* commit 2 : 핵심 로직을 담당하는 CarRacingPlay 클래스 구현
  * 0 ~ 9 사이의 랜덤 정수 값을 얻어야 합니다.
  * 랜덤 값이 4 이상인지 확인합니다.
  * 조건을 만족한다면 차가 한 칸 이동합니다.


* commit 3 : UI 로직인 출력값을 출력하는 ResultView 클래스 구현


---

## 4단계 - 자동차 경주
* commit 1 : step3 에서 진행했던 코드들 복사


* commit 2 : CarRacingInputView 와 입력값을 전달하는 controller 분리
  * CarRacingController 내부에서 CarRacingPlay 클래스를 사용하도록 구현
  * 최종 우승한 자동차 출력 추가
  * 자동차 이름을 입력받아서 Car 클래스를 생성하도록 추가