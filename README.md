# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

# STEP5 TODO
# STEP5 DONE
- [x] 4단계 피드백
  - [x] 자동차 객체를 불변으로 만들어 이동에 관한 스냅샷 찍기
  - [x] 우승자 이름이 아닌 객체로 반환하기(변경에 더 유연함)
  - [x] 테스트는 이름과 위치를 각각 비교하는 것이 아니고 객체로 비교해보기 (동등성 비교)
- [x] 5단계 요구사항
  - [x] 핵심 비지니스 로직을 가지는 객체를 domain 패키지로, UI 관련 패키지를 view 패키지로 나누기
  - [x] domain 패키지는 view 패키지에 의존하지 않도록 구현하기
  - [x] 테스트가 가능한 부분에 대해 단위 테스트 작성하기
- [x] 5단계 피드백
  - [x] Car 생성자 유효성 체크 -> Name과 Position Wrapping 및 유효성 체크
  - [x] move 아래에 canMove 메소드를 선언 -> 움직임 전략 패턴으로 코드 제거 됨
  - [x] 이동 조건 변경에 대응하기 위해 이동 여부를 전략 패턴으로 구현
  - [x] resultView에 비지니스로직이 있어 약간의 아쉬움 -> 비지니스 로직 제거
---
# STEP4 TODO
# STEP4 DONE
- [x] 각 자동차 이름 부여한다. 이름은 5글자를 초과 할 수 없다.
- [x] 전진하는 자동차는 출력할 때 자동차 이름을 같이 출력한다.
- [x] 자동차 이름은 쉼표를 기준으로 구분한다.
  - [x] 사용자가 입력한 이름 수만큼 자동차 생성한다.
  - [x] 이름과 위치 정보를 가지는 Car 객체로 구현한다.
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지 표시. 우승자는 한 명이상 가능하다.
- [x] 한 메소드에서는 오직 한 단계의 들여쓰기만 사용한다.
  - [x] 메소드 길이가 15라인 이하로 제한한다.
- [x] 피드백
  - [x] "A  ,B  ,C" 와 같은 input 케이스를 처리하기
  - [x]  car.getPosition() == getMaxPosition() -> 객체에 메시지로 전달하기
  - [x] Collectors.toList()와 Collectors.toUnmodifiableList 차이점 확인하기
  - [x] 레이스 결과를 담은 객체를 반환하여 startRace 메소드 개선시키기
--- 
# STEP3 TODO
# STEP3 DONE
- [x] 자동차 이동
  - [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  - [x] 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- [x] 입출력
  - [x] 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
  - [x] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
  - [x] UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- [x] 테스트
  - [x] 모든 로직에 단위 테스트를 구현한다
- [x] 구조 & 컨벤션
  - [x] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다
  - [x] else 예약어를 쓰지 않는다
- [x] 피드백
  - [x] 외부 참조가 없는 변수 private
  - [x] 테스트을 위한 파일은 테스트 패키지에만 두기 
  - [x] 클래스변수와 멤버변수 개행 
  - [x] inputView 책임에 맞게 print 문 변경하기
  - [x] carracing 패키지 이름 변경하기
  - [x] 자동차 스스로 움직일지 말지 결정
  - [x] 게임을 실행하는 역할에 맞게 Round 이름 변경해보기 -> cars로 변경
  - [x] Round init을 생성자에서 처리하기 -> cars에서 자동차 리스트 생성으로 변경 
