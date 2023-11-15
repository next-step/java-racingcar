# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## 기능 목록

1. InputView, ResultView, Conroller, RacingModel 클래스를 나눈다.
2. InputView에서 자동차 개수를 입력받는다.
3. InputView에서 시도할 횟수를 입력받는다.
4. controller에서 exception을 고려하여 inputview를 실행시킨다.
5. RacingModel에서 0에서 9 사이의 random값을 만드는 객체를 생성한다.
7. position에서 생성자로 포지션값을 설정할 수 있도록 / 테스트
8. position에서 음수값을 가졌을때 오류
8. car객체에서 position을 갖고있음
9. car에서 position을 받아서 전진 테스트
10. car에서 position을 받아서 멈춤 테스트
11. 라운드가 진행될 때 car객체들의 position을 받아와서 출력


