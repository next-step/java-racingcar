# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 구현 기능 목록
* 게임을 실행할 Application 클래스 생성
* 게임을 시작하고 입출력클래스를 다루는 RacingController 클래스 생성
* 자동차 대수와 시도 횟수 입력
* 입력한 자동차 대수와 시도 횟수를 가진 carInformation 클래스 생성
* 하나의 자동차를 다룰 car 객체 생성
* 게임 결과 구현
* random 함수를 만들 ramDomUtil 유틸리티성 클래스 생성
* 움직임을 표현할 move 인터페이스 생성
* 입력을 다룰 InputView 클래스
* 출력을 다룰 ResultView 클래스
* 모든 로직에 단위 테스트 구현
* 예외 처리