### [Pair Convention 👯](https://shpark-wootaecam.notion.site/Pair-Convention-4ac286189cf84b3db20479a3536b54ce?pvs=4)

저희 페어([박상현](https://github.com/PPakSang), [최세은](https://github.com/dahyen0o)) 의 규칙입니다

---

# 문자열 덧셈 계산기 🧮

## 미션 요구사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을
  전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)

- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 1차 기능 목록

### 입력

- 숫자 이외의 값 또는 음수인 경우 예외를 발생시킨다.
- 기본 구분자를 가지는 문자열을 구분자를 기준으로 분리한다.
- 커스텀 구분자를 가지는 문자열을 구분자를 기준으로 분리한다.

### 계산

- 각 숫자의 합을 구한다.

## 2차 사이드 이펙트 보완 목록

### 입력

- null 이 입력됐을 떄 0을 반환한다.
- 숫자 하나만 입력했을 때 해당 숫자를 반환한다.
- 오버(언더)플로우 발생 시 예외를 발생시킨다.

### 계산

- 오버(언더)플로우 발생 시 예외를 발생시킨다.

## 3차 리팩토링 목록

- 입력 처리, 파싱, 계산 영역을 별개의 클래스로 분리한다.

# 자동차 경주 🚘

## 미션 요구사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 1차 기능 목록

### 입력

- 쉼표를 기준으로 n대의 자동차 이름(5자 이하)을 입력 받는다.
- 몇 번의 이동을 할 것인지 입력 받는다.

### 경주

- 각 시행마다 0~9 사이의 랜덤값을 구하고, 전진할 자동차를 결정한다.

### 출력

- 각 시행마다 자동차가 전진한 횟수와 이름을 출력한다.
- 우승자를 출력한다.