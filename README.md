# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 목록
- [X] InputView 클래스 작성
  - [X] 자동차 대수를 입력 받고 입력 값을 반환
    - [X] 숫자인 지 체크 후 NumberFormatException 발생 시 예외처리
  - [X] 시도할 회수를 입력 받고 입력 값을 반환
    - [X] 숫자인 지 체크 후 NumberFormatException 발생 시 예외처리
- [X] RandomUtil 클래스 작성
  - [X] 0 ~ 9 사이의 숫자를 반환
- [X] Judgement 클래스 작성
  - [X] 파라미터로 넘어오는 숫자가 4 이상이면 true를 반환
- [X] Car 클래스 작성
  - [X] 자동차의 위치를 표시하는 Position 값 객체 생성
  - [X] 첫 위치를 1로 시작하는 Car 생성자 구현
  - [X] 자동차가 한 칸 전진하는 forward() 
  - [X] 모든 자동차의 위치를 반환하는 carPositions()
- [X] 경기를 출력하는 ResultView 작성
- [X] 경기 전체를 진행하는 Race 클래스 작성

## 4단계 기능목록
- [X] 쉼표(,)로 구분하여 자동차 이름을 입력받음 (InputView)
  - 5자 초과하는 경우 재 입력
  - Car 생성자를 통해 name을 부여한 Car 생성
- [X] Cars를 받아 이름 : 위치를 출력해주는 기능 구현 (ResultView)
- [ ] 가장 position 값이 높은 자동차를 리스트로 반환하는 winner() 메서드를 Cars에 구현
- [ ] 우승자 출력 기능 구현 (ResultView)