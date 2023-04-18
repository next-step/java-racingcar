# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

### step3 기능 요구 사항
- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 구현 기능 상세
1. 입력, Input-view
2. 출력, Result-view
3. 자동차(car) 객체는 움직인 거리를 StringBuffer로 가지며, 진행량을 String으로 출력 가능하다.
    - 처음에는 빈값으로 버퍼를 초기화 시켜준다.
    - 시도 횟수마다 진행량을 출력한다.
4. max값을 받아서 양수의 랜덤값을 출력해주는 객체 생성
5. 사용자의 입력값을 받아서 자동차 갯수와 시도횟수를 입력받게함(음수는 예외처리)

### step4 기능 요구 사항
- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

### 구현 기능 상세
1. car에 자동차 이름 멤버변수 추가와 Validation 추가.
2. 자동차 출력시에 자동차 이름도 뜨도록 진행.
3. inputView에서 자동차 횟수를 입력하는게 아니라 이름을 입력하도록
   - 쉼표로 분리(쉼표외에도 분리될 수 있게)
   - split 사용
4. 위의 기능들 기존 테스트메소드들로 테스트 하면서 진행.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)