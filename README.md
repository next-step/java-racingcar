# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 요구사항
- 기능 목록
    - 초간단 자동차 경주 게임을 구현
    - 사용자는 자동차의 대수와 시도 횟수를 입력 가능
    - 주어진 시도 횟수 동안 n대의 자동차가 움직인 상태를 화면에 출력
    - random 값이 4와 9 사이인 경우, 자동차가 전진
    - random 값이 0과 3 사이인 경우, 자동차가 멈춤
    - random 값이 0과 9 사이의 범위를 벗어난 경우, 예외 발생
- 프로그래밍 규칙
    - 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    - 자바 코드 컨벤션 (Code Style: [intellij idea Code Style. Java](https://www.jetbrains.com/help/idea/code-style-java.html))
    - else 예약어를 쓰지 않는다.
- 커밋 로그 요구사항
    - 참고문서: [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)