# 자동차 경주

## step3
## 기능 요구사항
1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
2. 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
3. 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
4. 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

## 프로그래밍 요구사항
1. 모든 로직에 단위 테스트를 구현 -> UI(System.out, System.in) 로직은 제외
2. 자바 코드 컨벤션을 지키면서 프로그래밍한다.
3. else 예약어를 쓰지 않는다. (switch/case 도 사용X)


## TO-DO
- [X]  사용자로부터 자동차 대수 입력 기능
- [X]  사용자로부터 시도할 횟수 입력 기능
- [X]  0부터 9사이 random 값을 만드는 유틸 생성
- [ ]  입력받은 회수 만큼 게임 진행
- [ ]  random 값이 4 이상일 경우 자동차 전진
- [ ]  자동차 상태를 출력