# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

Model
1. 자동차 클래스(Model.Car)
- 이름 및 이동 거리 정보를 담고 있다.

View
1. 에러 메시지 클래스(View.ErrorMessage)
- Exception 발생 시 메시지를 출력하고 다시 입력을 받는다.
2. 입력 클래스(View.Input)
- 자동차의 이름 및 시도할 횟수를 입력받는다.
3. 출력 클래스(View.Output)
- 경주 실행 결과 및 우승자를 출력한다.

Controller
1. 조절 클래스(Controller.Controller)
- 이동 회수를 입력받고, 그에 맞게 움직인다.

1. Application 클래스(Application)
- main 함수가 있으며, 코드를 실행하는 역할을 한다.