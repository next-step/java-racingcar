# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## step3
### 기능 구현할 목록 정리
1. 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.(InputView에서 구현, UI이므로 단위 테스트X)
2. 입력한 자동차의 대수에 따라 자동차 객체 생성 하기
3. 생성한 객체 배열에 담기(자동차의 대수 = 배열의 크기)
4. 전진하는 조건(상수)를 받아 4보다 같거나 클 경우 전진(+1), 작을 경우 멈춤(+0) 하는 로직 구현
5. 주어진 횟수 만큼 전진, 멈춤 로직 확인하기(ex)자동차 1,2번은 5, 3번은 0) 
6. 전진하는 조건(random)값으로 받기(random 받는 부분이므로 단위 테스트X)
7. 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.(ResultView에서 구현, UI이므로 단위 테스트X)