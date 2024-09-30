# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


# STEP3 TODO
- [ ] 자동차 스스로 움직일지 말지 결정 
- [ ] carController 이름과 역할 바꿔보기 
- [ ] inputView 책임에 맞게 print 문 변경하기
- [ ] 게임을 실행하는 역할에 맞게 Round 이름 변경해보기
- [ ] Rount init을 생성자에서 처리하기
- [ ] step3 패키지 이름 변경하기

#  STEP3 DONE
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
- [ ] 피드백
  - [x] 외부 참조가 없는 변수 private
  - [x] 테스트을 위한 파일은 테스트 패키지에만 두기 
  - [x] 클래스변수와 멤버변수 개행 
