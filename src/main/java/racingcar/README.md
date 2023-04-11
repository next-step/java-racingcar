#### 사용자 (User)
- 사용자는 자동차의 대수를 입력한다.
- 사용자는 시도할 회수를 입력한다.

#### 자동차 (Car)
- 현재 위치를 기억한다.

#### 자동차들 (Cars)
- 사용자가 입력한 대수, 회수만큼 경주를 시작한다.
- 라운드마다 현재 위치를 출력한다.

#### 자동차 위치 (Position)
- 자동차의 현재 위치를 가지고 있다.
- 전진하는 조건은 0-9 사이에서 random 값이 4이상일 경우 전진한다.
- 4미만인 경우 움직이지 않는다.

---
#### 힌트
- 값을 입력 받는 API는 Scanner를 이용한다.
- Scanner scanner = new Scanner(System.in);
- String value = scanner.nextLine();
- int number = scanner.nextInt();
- 랜덤 값은 자바 java.util.Random 클래스의 nextInt(10) 메소드를 활용한