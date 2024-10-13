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

### TODO
- [x] 사용자는 자동차 수, 시도 수 를 입력해서 게임을 실행 할 수 있다.
- [x] 모든 자동차가 이동 횟수 만큼 실행되고 나면 게임은 종료 된다.
- [x] 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- [x] 자동차의 상태를 화면에 출력한다. 자동차 전진 횟수는 '-' 의 개수와 같다

---


## 4단계 - 자동차 경주(우승자)

### TODO
- [x] 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

---

## 5단계 - 자동차 경주(리팩토링)

### TODO
- [x] 4단계 피드백 반영 - RacingCarPosition 에서 name 속성 제거
- [ ] 4단계 피드백 반영 - RacingCar[] 를 List 로 변경 
- [ ] 핵심 비지니스 로직을 가지는 객체를 domain 패키지에 구현한다.
- [ ] UI 관련한 객체를 view 패키지에 구현한다.
- [ ] 테스트 가능한 부분에 대해서만 단위 테스트를 진행