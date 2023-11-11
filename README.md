# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# step 2 : 문자열 덧셈 계산기를 통한 TDD 실습
## 기능 목록:
### 1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
- [X] 빈 문자열 또는 null을 전달하는 경우 0을 반환한다.
- [X] 쉼표(,)를 가지는 문자열의 경우, 구분자를 기준으로 숫자 배열로 전환하여 각 숫자를 합산한 합계를 반환한다.
- [X] 콜론(:)을 가지는 문자열의 경우, 구분자를 기준으로 숫자 배열로 전환하여 각 숫자를 합산한 합계를 반환한다.
- [X] 쉼표와 콜론(:)을 둘다 가지는 문자열의 경우, 구분자를 기준으로 숫자 배열로 전환하여 각 숫자를 합산한 합계를 반환한다.
### 2. 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
### 3. 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
- [X] 각 문자열 중 숫자가 아닌값이 있는경우 예외 전달한다.
- [X] 각 문자열 중 음수가 있는경우 예외 전달한다.

# step 3 : 자동차 경주
## 기능 목록:
### 1. 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [X] 어플리케이션이 시작되면, 사용자가 몇대의 자동차를 사용할것인지 입력한다.
- [X] 사용자가 자동차들이 몇 번의 이동을 할 것인지를 입력한다.
### 2. 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- [X] 0에서 9 사이에서의 랜덤 숫자를 구한다.
- [X] 숫자가 4이상일 경우 해당 자동차는 이동한다. (4 미만일경우 그대로)
### 3. 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
- [X] 모든 자동차들의 이동 여부가 결정되면, 화면에 전체 자동차 이동거리를 출력한다.
### 4.각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- [X] 각 자동차에 이름을 부여할 수 있다.
- [X] 자동차 이름은 5자를 초과할 수 없다.
### 5.전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [X] 결과 출력시 각 자동차의 이름을 함께 출력한다.
### 6.자동차 이름은 쉼표(,)를 기준으로 구분한다.
- [X] 각 자동차 이름은 사용자 입력값의 쉼표를 기준으로 구분한다.
### 7.자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. (우승자는 한명 이상일 수 있다.)
- [X] 게임이 종료된 후 이동값이 가장 높은 자동차들의 이름 리스트를 출력한다.

