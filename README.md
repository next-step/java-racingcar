# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 구현기능 목록
1. 몇 대의 자동차로 몇 번의 이동을 할 것인지 사용자로부터 입력받기
2. 각 자동차가 조건값에 맞춰 전진 or 멈춤
   1. 조건값 생성: 0~9의 random 값
   2. 전진 or 멈춤: 4 이상인 경우 자동차 전진, 아니면 멈춤  
3. 자동차의 상태출력