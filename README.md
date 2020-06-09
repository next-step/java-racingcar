# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 구현할 기능 목록
* UI 로직(InputView, ResultView 클래스)
* 랜덤 값 생성 메서드
* 자동차 도메인
* 전체 게임 횟수/자동차 상태 관리 로직(RacingGame 클래스)

## 4단계 자동차 경주 (우승자)를 위한 추가 구현 기능 목록
* [UI 로직] 경주할 자동차 이름을 받고 쉼표(,) 기준으로 구분
* [UI 로직] 자동차 이름 5자로 제한
* 자동차 도메인에 자동차명 필드 추가
* [UI 로직] 출력 로직에서 자동차명 출력 기능 추가
* [test] 추가 로직에 대한 테스트 코드 작성
* [Refactor] indent 1단계 제한, else 제거