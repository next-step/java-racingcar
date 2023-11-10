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
6. radom값이 4 이상일 경우 true 반환 테스트
7. 6번 조건이 만족될때 전진하는 객체 생성 / 테스트
8. 6번 조건이 만족되지 않을때 정지하는 객체 생성 / 테스트
9. round마다 자동차 개수만큼 랜덤 객체 호출
10. ResultView에 전진시 "-"출력
