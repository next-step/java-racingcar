# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 구현 기능 목록

### Game Machine

- Racing Game Start(main)

### InputView

- 질문
- 자동차 대수 입력
- 시도 횟수 입력(한 줄에 모든 결과를 타나낼 수 있게 20회 미만으로 설정)
- 숫자가 아닌 다른 것을 입력했을 때 예외 처리

### Racing Game

- 자동차 및 운전자 생성
- 라운드 결정
- 게임 시작

### Car

- 움직인 칸
- 움직임

### Driver

- 주사위를 던져서 움직일지 안 움직일지를 판단

### ResultView

- 결과 출력
- 딜레이 0.5초

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
