# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 구현 기능 목록

### InputView
Scanner를 통해 입력값을 받는 클래스

* int getCarCount : 자동차의 대수 입력
* int getGameCount : 게임을 시도할 횟수 입력

### Racing
자동차 경주 게임을 담당하는 메인 클래스

* race(int, int) : 자동차 대수와 시도 횟수를 받아 게임을 진행하는 메소드
* printResult() : "실행 결과" 텍스트를 출력 호출
* printResult(int[]) : 게임 한 회 결과 출력 호출

### ResultView
게임 결과를 출력하는 클래스
* printResultHeader() : "실행 결과" 텍스트 호출
* printGameResult(int[]) : 게임 한 회 결과를 출력 
