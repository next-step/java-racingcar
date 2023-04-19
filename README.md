# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항
* 입/출력
  + [ ] 자동차 이름을 쉼표로 구분하여 1회 입력받는다.
  + [X] 시도 횟수를 1회 입력 받는다.
  + [X] 1회 시도마다 결과를 출력한다.
  + [ ] 자동차를 출력할 때 자동차 이름을 함께 출력한다.
  + [ ] 게임의 우승자를 출력한다.
* 컨트롤러
  + [X] 입력 받은 갯수만큼 자동차를 생성하도록 명령한다.
  + [X] 입력 받은 횟수만큼 이동을 시도하도록 명령한다.
  + [ ] 가장 멀리 이동한 자동차를 우승자로 선정한다.
* 자동차컬렉션
  + [X] 입력 받은 갯수만큼 자동차 리스트를 가진다.
  + [X] 보유한 자동차에 모두 이동을 시도한다.
  + [X] 보유한 자동차의 위치 리스트를 반환할 수 있다.
* 자동차
  + [X] 이동 시도 명령을 받았을 때, 랜덤 bool을 통해 이동 여부를 결정한다. 
  + [X] 이동 시 위치를 1만큼 증가시킨다.
  + [X] 위치 정보를 반환할 수 있다.
  + [ ] 각 자동차는 5자 이하의 이름을 가진다.
* 랜덤 bool
  + [x] 0~9 중 하나의 숫자를 랜덤으로 생성한다.
  + [x] 0~3을 생성하면 False 값을 반환한다.
  + [x] 4~9를 생성하면 True 값을 반환한다.


## 프로그래밍 요구사항
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  + 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
* UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
  + 자바 코드 컨벤션을 지키면서 프로그래밍한다.
* 이 과정의 Code Style은 intellij idea Code Style. Java을 따른다.
  + intellij idea Code Style. Java을 따르려면 code formatting 단축키(Windows : Ctrl + Alt + L. Mac : ⌥ (Option) + ⌘ (Command) + L.)를 사용한다.
* else 예약어를 쓰지 않는다.
  + 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  + else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

## 기능 목록 및 commit 로그 요구사항
* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
  + 참고문서: [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
