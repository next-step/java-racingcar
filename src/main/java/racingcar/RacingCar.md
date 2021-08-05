# 3단계 - 자동차 경주

### 기능 요구사항

- 초간단 자동차 경주 게임을 구현
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있음
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 함
- 전진하는 조건은 0에서 9사이 random 값을 구한 후 random 값이 4이상일 경우
- 자동차의 상태를 화면에 출력, 어느 시점에 출력할 것인지에 대한 제약은 없음

### 실행 결과

- 위 요구사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과
```
자동차는 몇 대 인가?
3
몇 회 시도 할것 인가?
5

실행 결과
-
-
-

--
-
--

---
--
---

----
---
----

----
----
-----
```

### 힌트
- 값을 입력 받는 API는 Scanner를 이용

```java
Scanner scanner = new Scanner(System.in);
String value = scanner.nextLine();
int number = scanner.nextInt(); 
```
- 랜덤 값은 자바 java.util.Random 클래스의 nextInt(10) 메소드를 활용

### 프로그래밍 요구사항
- 모든 로직에 단위 테스트를 구현. 단, UI(System.out, System.in)로직 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직 구분
  - UI 로직을 InputView, ResultView 와 같은 클래스를 추가해 분리

- 자바 코드 컨벤션을 지키면서 프로그래밍
  - 참고 : https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596

- else 예약어 사용 안함
  - 힌트 : if 조건절에 값을 return 하는 방식으로 구현하면 else 사용 하지 않아도 됨
  - switch/case 허용 하지 않음


