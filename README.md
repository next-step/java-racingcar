### 기능 요구 사항
- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 구현 기능 상세

1. 자동차 객체는 개별적으로 전진한 량을 가진다
   - 전진한 량은 최초 생성시 비어있는 값으로 초기화 한다. (\"\")
   - 전진량을 정량적으로 측정 할 수 있도록 Long 값으로 컬럼을 갖는다.
2. 사용자는 몇대의 자동차로 몇번의 이동을 할 것인지를 입력할 수 있어야 한다.
    - 사용자는 몇대의 자동차로 이동할 것인지 입력할 수 있다. (음수 또는 그 이외의 값을 입력할 경우 예외를 발생시킨다)
3. 0~9 사이의 정수를 발생시키는 random 함수 발생 객체 개발

## Step 5 코드 개선사항

- [x] Car 클래스와 Cars 클래스에서 UI 를 의존하는 부분을 끊음
```java
    // 해당 코드 삭제후 리펙터링 진행
    public void printTravelDistanceWithCarName() {
        printSource(getDistanceAsPrintForm());
    }
```
- [x] Car 객체 에 대해 Getter 메서드를 삭제함
- [x] Car 객체에 명시되어있는 UI 소스들을 View 단으로 이관함.

```java
    /* View 단에 존재 해야할 상수 */    

    private static final String CAR_DISTANCE_DISPLAY_UNIT = "-";

    private static final String CAR_START_POSITION_DISPLAY_STRING = "";

    private static final String CAR_NAME_AND_DISTANCE_DELIMITER = " : ";
```

- [x] Domain 로직은 View 단과 절대 소통하지 않으며 View 단만 도메인 로직에 의존하도록 수정한다.

- [x] 코드에 산재되어있는 public static 함수를 전체 걷어낸다.
