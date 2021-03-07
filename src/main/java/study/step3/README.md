## 3단계 - 자동차 경주

### 기능 요구사항
* 초간단 자동차 경주 게임을 구현
* 주어진 횟수 동안 n대의 자동차는 ***전진(go)*** or ***멈춤(stop)***
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 **<span style="color:blue">*입력*</span>** 할 수 있어야 한다.
* 전진조건은 0에서 9사이의 random 값을 구한 후 random 값이 **<span style="color:blue">*4*</span>** 이상일 경우
* 자동차의 상태를 화면에 출력. 어느 시점에 출력할 것인지에 대한 제약은 없다.

> 실행결과
* 위 요구사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.
```text
자동차 대수는 몇 대 인가요?
3
시도할 회수는 몇 회 인가요?
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

> 힌트
* 값을 입력 받는 API는 Scanner를 이용한다.
```java
Scanner scanner = new Scanner(System.in);
String value = scanner.nextLine();
int number = scanner.nextInt();
```
* 랜덤 값은 자바 java.util.Random 클래스의 nextInt(10) 메소드를 활용한다.

### 프로그래밍 요구사항
* 모든 로직에 단위 테스트를 구현
* 자바 코드 컨벤션을 지키면서 프로그래밍
* else 예약어를 쓰지 않는다

