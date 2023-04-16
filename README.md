# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## Step 1. 학습 테스트 실습

### String 클래스에 대한 학습 테스트
- [x] "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
- [x] "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
- [x] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
- [x] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
- [x] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
- [x] JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

<br>

## Step 2. 문자열 덧셈 계산기

### 기능 요구사항
- [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- [x] 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

### 기능 요구사항 분리 및 힌트
- [x] 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
    ```
    if (text == null) {}
    if (text.isEmpty()) {}
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
    ```java
    int number = Integer.parseInt(text);
- [x] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
    ```
    String[] numbers = text.split(",");
    // 앞 단계의 구분자가 없는 경우도 split()을 활용해 구현할 수 있는지 검토해 본다.
- [x] 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)]
    ```java
    String[] tokens= text.split(",|:");

- [x] “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
    ```
    // java.util.regex 패키지의 Matcher, Pattern import
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
    if (m.find()) {
        String customDelimiter = m.group(1);
        String[] tokens= m.group(2).split(customDelimiter);
        // 덧셈 구현
    }

- [x] 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
  - [x] 구글에서 “junit4 expected exception”으로 검색해 해결책을 찾는다.

<br>

## Step 3. 자동차 경주

### 기능 요구사항
- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [x] 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지 입력할 수 있다.
  - [x] 값을 입력받는 API는 Scanner를 이용한다.
- [ ] 전진 조건은 0 ~ 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우다.
  - [x] 랜덤값은 자바 java.util.Random 클래스의 nextInt(10) 메서드를 활용한다.
- [ ] 자동차의 상태를 화면에 출력한다.
  - 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 프로그래밍 요구사항
- [x] 모든 로직에 단위 테스트를 구현한다. (UI 로직 제외)
  - [x] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - [x] UI로직을 InputView, ResultView와 같은 클래스를 분리해 추가한다.
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍 한다.
  - [x] code formatting 단축키 ctrl + alt + L
- [x] else 예약어를 쓰지 않는다.
  - [x] if 조건절에서 값을 return 하는 방식으로 구현한다.
  - [x] switch/case도 허용하지 않는다. 

### 기능 목록 및 commit 로그 요구사항
- [x] 기능 구현 전 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
