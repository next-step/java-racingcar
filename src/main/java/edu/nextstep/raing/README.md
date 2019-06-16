## 2단계 - 자동차 경주

### 기능 요구사항
- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 요구사항 설계

##### UI 로직
- input View (System.in)
    - [X] 자동차 대수
    - [X] 전진 시도 횟수

- result View (System.out)
    - [X] 전진 시도마다 상태값 출력
    
##### 핵심 로직
- Main Class 
    - [X] 자동차 대수와 전진 시도 횟수 입력받기
    - [X] 입력받은 input(자동차 대수, 전진 횟수)값을 통해 move메서드 수행

- Car Class
    - [X] 자동차 객체 생성(멤버변수 : move, currentIndex)

- Racing Class
    - [X] Main Class로 부터 입력받은 값을 통해 생성자초기화
    - [X] 전진 여부를 판단하는 기능 (Random Class - nextInt())
    - [X] 각각의 자동차의 전진 기능
    
### 문의사항

1. CarTest.class
    - Test코드에 기존에 구현한 Test코드를 호출하여 사용해도 문제가 없을까요? ex) this.이동()

2. CarRacingApplication.class
    - Main class의 void type method는 테스트를 어떤식으로 해야할지요

3. CarRacing.class
    - move() 메서드는 외부접근(public) 가능하게 한 뒤 내부 메서드별 분리는 private으로 감추는게 더 좋을듯 하다고 판단을 하였는데 맞을까요?
    
    - 만일 위의 생각이 맞다면 move() 메서드를 제외한 메서드는 private으로 되어있어 테스트를 작성이 안되는데 메서드별 단위테스트는 이럴때 어떤식으로 진행하면 될까요? (https://coronasdk.tistory.com/658) 블로그의 내용처럼 진행을 해야할 까요?
    
