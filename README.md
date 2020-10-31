#자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 구현 기능 목록

### Game Machine

- Racing Game Start(main)

### InputView

- 자동차 대수 입력(1 이상 20 미만)
- 시도 횟수 입력(한 줄에 모든 결과를 타나낼 수 있게 20 미만으로 설정)

### InputValidator

- 숫자가 아닌 다른 것을 입력했을 때 예외 처리
- 0 이하의 숫자를 입력했을 때의 예외처리
- 20 이상의 숫자를 입력했을 때의 예외처리
- null 예외처리

### Racing Game

- 라운드 설정
- 자동차 대수 설정
- 게임 시작

### RacingCars

- 자동차 생성
- 자동차 반환
- 레이스

### Car

- 움직인 거리 반환
- 전진

### Roullete

- 룰렛을 돌려서 랜덤값 생성

### ResultView

- 결과 출력

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
