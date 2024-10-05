# 자동차 경주 게임
## 프로젝트 개요
이 프로젝트는 TDD와 클린 코드 원칙을 실습하기 위해 설계된 간단한 자동차 경주 게임입니다.

## 주요 기능
- 자동차 이름 및 시도 횟수 입력
  - 각 자동차의 이름을 쉼표로 구분하여 부여할 수 있습니다.
  - 사용자가 시도 횟수를 입력할 수 있습니다.
- 전진 조건: 0부터 9 사이의 랜덤 숫자가 주어지며, 4 이상일 경우 자동차가 전진합니다.
- 경주 결과 출력
  - 각 시도별로 자동차들의 위치를 아름과 함께 화면에 출력합니다.
  - 우승자들의 이름을 출력합니다.

## 개발 원칙
- indent(들여쓰기) depth를 2를 넘지 않도록 구현
- 메소드의 길이가 15라인을 넘어가지 않도록 구현
- else 예약어를 사용하지 않고 구현
- 모든 로직에 단위 테스트를 구현
    - 단, UI(System.out, System.in) 로직은 제외합니다.
- 자바 코드 컨벤션 ([intellij idea Code Style. Java](https://www.jetbrains.com/help/idea/code-style-java.html))
- 커밋 메시지 규칙 ([AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153))

## 코드 리뷰 방식
- [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)