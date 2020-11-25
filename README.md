# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 목록

### Model

- Cars
  - 자동차 리스트 만들기

- Splitter
  - 자동차 이름들 배열로 분리

- Car
  - 자동차 객체 생성
  - 이동하기

- Name
  - 이름 객체 세팅
  - 이름값 반환하기

- Position
  - 값 세팅
  - 값이 증가된 새로운 객체 반환
  - 값 반환

- Rounds
  - 경기 객체 생성
  - 경기 시작

- Round
  - 경기 객체 생성
  - 경기 시작

- RandomGenerator
  - 랜덤값 출력

- Winners
  - 우승자 리스트 만들기

- Winner
  - 우승자 객체 생성

- WinnerPicker
  - 우승자 고르기

### View
- InputView
  - 자동차 이름들 입력 받기
  - 경기 수 입력 받기

- ResultView
  - 경기별 이동거리 출력
  - 실행결과 출력
  - 우승자 출력

### Controller
- GameController
  - InputView에서 데이터를 받아 Model을 구성
  - Model의 데이터와 행위를 통해 프로세스 동작
  - ResultView에 Model의 데이터를 전달하여 결과 출력


객체 생성에 대한 테스트를 할 수 있는 방법이 있을
