# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 기능구현 목록
- [x] 이름 입력 받아 parsing 하기 - User.getCarName()
- [x] 입력값을 토대로 자동차 생성하기 - Car()
  - [x] 랜덤값에 따라 자동차 이동정보 갱신 -Car.MoveForward()
- [x] 시도할 횟수 입력받기 - User.getTryCount()
- [x] 0에서 9까지 랜덤 수 발생 - RandomGenerator.generateRandomNumber()
- [x] 각 차수마다 자동차의 위치 출력
- [x] 제일 많이 이동한 우승자 구하기

## 예외처리 목록
- [x] 자동차 이름은 5자를 초과허는 경우
- [] 자동차 이름이 1글자 미만인 경우
- [] 시도할 횟수가 0이하의 숫자인 경우


## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)