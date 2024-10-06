# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 자동차 경주 게임

DONE
---------
*  자동차는 전진 할 수 있다. (4,5,6,7,8,9=>전진)
* 자동차는 전진하지 않을 수 있다.(0,1,2,3=>전진 불가)
* 주어진 n대의 자동차를 만들수 있다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
* 주어진 횟수 만큼 자동차를 이동 시킬 수 있다.
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
```
자동차 대수는 몇 대 인가요?
3
시도할 회수는 몇 회 인가요?
5
```
(int 범위를 넘어가거나 음수 입력->입력 할 수 없는 숫자 입니다.자동차 수 or 시도 횟수가 0인경우=>비 출력 후 종료)
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.(상태는 -로 출력한다)
