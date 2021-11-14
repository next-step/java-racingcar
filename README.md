# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 🚀 3단계 - 자동차 경주

### 기능 목록 정의

- (UI) - 자동차 대수 입력 UI 기능 및 시도 횟수 입력 기능 구현 (v)
- (UI) - 자동차 상태 출력 기능 구현 (v)
- 사용자 입력한 대수에 맞는 자동차가 생성되어야 한다. (v)
- 입력받은 회차에 따라, 게임이 진행되어야 한다. (v)
- 자동차 전진 기능 구현 (random 값이 4이상인 경우, 한칸 전진해야 한다.) (v)
- 자동차 멈춤 기능 구현 (0~3 인경우 멈춰야 한다.) (v)

## 🚀 4단계 - 자동차 경주(우승자)

### 기능 목록 정의

- (UI) - 자동차 이름 입력 UI 기능 구현
    - 자동차 이름은 5자를 초과해서는 안된다.

- (UI) - 자동차 상태 출력 기능 변경
    - 자동차 이름이 함께 출력 되어야 한다.
    - 우승자 출력 기능이 구현되어야 한다.

- 자동차 게임 우승자 기능 구현