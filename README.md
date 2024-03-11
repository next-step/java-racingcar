# 자동차 경주

## 기능 요구사항

* 초간단 자동차 경주 게임을 구현한다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

## 기능 구현 목록

- [x] 주어진 횟수만큼 자동차는 "-"만큼 전진한다
    - [x] 주어진 횟수가 1이면 자동차는 "-"만큼 전진한다
    - [x] 주어진 횟수가 2이면(random 적용 X) 자동차는 "--" 만큼 전진한다.
    - [x] 주어진 횟수가 3이면(random 적용 X) 자동차는 "---" 만큼 전진한다.
- [ ] 주어진 자동차 수만큼 자동차가 생성된다
    - [ ] 자동차 1개를 1회: "-"
    - [ ] 자동차 2개를 1회: "-", (다음줄)"-"
    - [ ] 자동차 3개를 1회: "-", (다음줄)"-", (다음줄)"-"
- [ ] 위의 두 경우를 합쳤을 때
  - [ ] 자동차 2개를 2회: "-", (다음줄)"-" 한 줄 띄고 "--", (다음줄)"--"
  - [ ] 자동차 3개를 3회: "-","-","-","--","--","--","---","---","---"
- [ ] random값이 4이상일 때 전진한다 

