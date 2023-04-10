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

### 구현할 기능 목록

* [x] 사용자로부터 입력받는 기능
    - [x] 사용자로부터 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력받는다.
    - [x] 입력 받은 값을 옵션정보로 생성한다.
* [x] 자동차 기능
    - [x] 자동차는 전진 또는 멈출 수 있다.
    - [x] 자동차는 엔진과 위치를 갖는다.
    - [x] 자동차는 위치정보를 반환한다.
* [x] 자동차 위치 기능
    - [x] 자동차가 얼만큼 전진했는지 기록한다.
    - [x] 회차별 움직임을 저장한다.
* [x] 자동차 엔진기능
    - [x] 랜덤하게 전진 여부 결정한다.
    - [x] 결정된 전진 여부를 반환한다.
* [x] 경주 기능
    - [x] 주어진 횟수 동안 n대의 자동차가 경주하도록 한다.
* [x] 결과 출력 기능
    - [x] 경주 결과를 화면에 출력한다.
