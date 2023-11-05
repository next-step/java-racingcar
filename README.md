<!-- TOC -->

* [자동차 경주 게임](#자동차-경주-게임)
    * [진행 방법](#진행-방법)
    * [온라인 코드 리뷰 과정](#온라인-코드-리뷰-과정)
    * [Step2](#step2)
        * [프로그래밍 요구사항](#프로그래밍-요구사항)
        * [기능목록](#기능목록)
    * [Step3](#step3)
        * [프로그래밍 요구사항](#프로그래밍-요구사항-1)
        * [기능 목록](#기능-목록)

<!-- TOC -->

---

# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## Step2

### 프로그래밍 요구사항

- 최대한 메서드 분리를 시켜, 하나의 메서드가 하나의 동작만을 하게 한다.

### 기능목록

- [X] ~~빈 문자열 또는 null 값인 경우 0을 반환 ("" => 0, null => 0)~~
- [X] ~~숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환("1,2"=>3)~~
- [X] ~~구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.("1,2:3" => 6)~~
- [X] ~~"//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다.("//;\n1;2;3" => 6)~~
- [X] ~~음수를 전달할 경우 RuntimeException 예외 발생("-1,2,3" => RuntimeException)~~
- [X] ~~숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환 ("1" => 1)~~

---

## Step3

### 프로그래밍 요구사항

- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다. (Code Style : intellij idea Code Style. Java)
- else 예약어를 쓰지 않는다.
    - early return을 사용한다.
    - switch/case도 허용하지 않는다.

### 기능 목록

- [X] ~~자동차 경주를 실행할 Main 메서드를 만든다.~~
- [X] ~~사용자로부터 자동차 대수 및 시도할 횟수를 입력받는다.~~
- [X] ~~자동차의 전진한 거리를 확인한다.~~
- [X] ~~사용자로부터 입력받는 값에 따라 자동차 객체를 생성한다.~~
- [X] ~~각 횟수마다 각 자동차에 대해서 0이상 9이하의 random 값을 구한다.~~
- [X] ~~구한 random 값이 0이상 3이하인 경우 자동차는 움직이지 않는다.~~
- [X] ~~구한 random 값이 4이상 9이하인 경우 자동차는 한칸 전진한다.~~
- [X] ~~각 횟수마다 현재 진행 결과를 출력한다~~

