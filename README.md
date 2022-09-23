# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 자동차 경주 게임 기능
* 각 자동차는 연료로 움직이며, 주어진 연료량에 따라 주행이 가능할 수도 불가할 수도 있다.
* 주유소는 랜덤한 양의 기름을 판다.
* 연료탱크는 자동차에 주유할 기름들을 받아 놓을 수 있다.
* 전광판은 각 회차마다의 자동차의 주행거리를 기록해둘 수 있다. 원하면 특정 회차에서 모든 차들의 주행기록이나, 특정 차량의 주행기록을 확인할 수 있다. 
* 게임패드는 사용자로부터 원하는 차량 수와 경기수를 입력받는다.
* 게임이니셜라이져는 게임 실행을 위한 데이터들을 생성한다.
* 게임은 게임이니셜라이져로부터 초기화되어 차량정보와 연료탱크를 이용해 경주를 운영할 수 있다.
* 게임패드로부터 원하는 게임회차와 차량수를 입력받으며, 스크린으로부터 경기 결과를 확인할 수 있다.