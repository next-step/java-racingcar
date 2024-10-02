# 자동차 경주 게임
## 코드 리뷰
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항
- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

## 기능 정리
1. 자동차 대수와 시도 횟수를 입력
2. 자동차는 전진조건에 따라 전진 혹은 정지
   - 전진조건: 0에서 9 사이의 random 값을 구한 후, 4이상이면 전진하고 4미만이면 멈춘다.
3. 시도 횟수별 자동차의 위치를 출력

## 프로그래밍 규칙
- 모든 로직에 단위 테스트를 구현한다.
  - 단, UI(System.out, System.in) 로직은 제외
- else 예약어를 쓰지 않는다.
- 자바 코드 컨벤션 ([intellij idea Code Style. Java](https://www.jetbrains.com/help/idea/code-style-java.html))
- 커밋 메시지 규칙 ([AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153))