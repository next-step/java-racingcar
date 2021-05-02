# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 게임 안내
- 경주에 참여할 자동차들의 이름과 시도 횟수를 입력해주세요. 
    - 자동차 이름은 쉼표(,)로 구분
    - 자동차 이름은 5 글자 이하만 가능
- 각 자동차들은 입력한 횟수동안 전진 혹은 정지를 반복합니다. 
- 매 횟수마다 자동차별 스코어를 안내해드려요.
- 입력한 횟수가 지나면 경주가 종료되며, 제일 많이 전진한 자동차가 최종 우승하게 됩니다. (동점 시 공동 우승)
  
## 구현 기능 
##### RacingCarGamePlayer : 사용자에게 자동차 경주 게임 UI 제공
- 경주 게임을 시작하기 위한 정보 입력 : 사용자에게 자동차들의 이름과 시도 횟수를 입력받음
- 경주 스코어 안내 : 경주에 참여한 자동차들별 스코어를 출력
- 최종 우승자 안내

##### RacingCarGame : 자동차 경주 게임
- 자동차 경주 게임 생성 : 출전 자동차들이 등록된 경주 게임 생성
- 라운드 횟수만큼 자동차에게 이동 요청
- 최종 우승자 선발

##### RacingCar : 경주 자동차
- 경주 자동차 생성 : 이름과 현재 스코어를 가진 자동차 생성
- 자동차 이동 : 랜덤한 수가 특정 수 이상이면 전진, 이하면 정지

##### RandomUtil : 랜덤한 값을 추출하는 기능 모음
- 랜덤한 수 뽑기
