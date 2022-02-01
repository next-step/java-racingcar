# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 기능구현 목록
- [x] 이름 입력 받아 쉼표기준으로 parsing 하기 - User.getCarName()
  - [x] 자동차 이름은 5자를 초과할 수 없다.
- [x] 사용자 입력값을 토대로 자동차 생성하기 - Car()
  - [x] 랜덤값을 추출한 뒤, 랜덤값이 4 이상일때만 전진 - Car.MoveForward()
- [x] 이동할 횟수 입력받기 - User.getTryCount()
- [x] 0에서 9까지 랜덤 수 발생 - RandomGenerator.generateRandomNumber()
- [x] 각 차수마다 각 자동차의 이름과 이동 결과 출력
- [x] 제일 많이 이동한 우승자 구하기



## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)