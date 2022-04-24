# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## 3단계 - 자동차 경주

### 흐름
1. 자동차 대수를 입력받는다.
2. 몇 회 시도할 것인지 입력받는다.
3. 자동차 수만큼 0 - 9 사이에 랜덤 값을 구한다.
   이때, 4이상 값이 나오면 자동차가 전진하고 아니면 멈춘다.
4. 현재 자동차의 상태를 출력한다.
5. n회 동안 3,4 번을 반복한다.
6. 게임을 종료한다.

### 구현 기능 목록
1. 자동차 대수, 시도 횟수 입력 받는 기능
    1-a. 이때 입력값이 빈문자, NULL, 음수, 숫자가 아닌 문자 일 때 예외가 발생 한다.
   
2. 0이상 9이하의 숫자 중에서 랜덤 값 구하는 기능
    2-a. 0미만 9초과의 숫자가 랜덤 값으로 나오면 예외가 발생한다.
    2-b. 1이상 3이하의 랜덤 값이 나오면 해당 차례의 자동차가 움직이지 않는다.
    2-b`. 4이상 9이하의 랜덤 값이 나오면 해당 차례의 자동차가 움직여 '-' 가 추가된다.

3. 매 회마다 자동차 상태를 출력하는 기능

## 4단계 - 자동차 경주(우승자)

### 흐름
1. 경주할 자동차 이름을 쉼표(,)로 구분하여 입력받는다.
   이 때, 입력받은 자동차의 수를 구한다.
2. 시도할 횟수를 입력받는다.
3. 자동차마다 차례대로 0 - 9 사이의 랜덤 값을 구한다.  
   이 때, 4이상의 값이 나오면 그 자동차는 전진하고 아니면 멈춘다.
4. 자동차들의 현재 위치를 이름과 함께 출력한다.
5. 시도 횟수만큼 3번 ~ 4번을 반복한다.
6. 최종 우승자의 이름을 출력한다.
   이 때, 우승자는 여러명이 될 수도 있다.

### 구현할 기능 목록
1. 자동차 이름을 입력 받는 기능
    1-a. 이 때, 구분자로 쉼표를 사용한다.
    1-b. 빈문자열이나 NULL 값이 입력값으로 들어오면 예외가 발생한다.
    1-c. 입력한 이름의 숫자만큼 자동차 수가 생성된다.
   
2. 시도할 횟수를 입력 받는 기능
    2-a. 이 때, 입력받은 시도 횟수가 0 미만이면 예외가 발생한다.
   
3. 랜덤 값을 구하는 기능
    3-a. 이 때, 랜덤 값이 0이상 9이하가 아니면 예외가 발생한다.
   
4. 자동차가 조건을 만족하는지 확인하고 움직이는 기능
    4-a. 랜덤 값이 0이상 4미만 이면, 자동차는 정지한다.
    4-b. 랜덤 값이 4이상 9이하 이면, 자동차가 움직인다.
    
5. 매 회마다, 현재 자동차 경주에 참여한 자동차들의 위치 출력 기능

6. 최종 우승자의 이름을 출력하는 기능
    6-a. 1칸 이상 움직인 자동차 중에서 우승자를 구한다.
    6-b. 우승자는 한 명 이상이 될 수 있다.
    
