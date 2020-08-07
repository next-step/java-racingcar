# 자동차 경주 게임

##Step 5

#### 기능 목록
ResultView.showFinalChampion 로직 분리
RunRace Domain으로 변경
신규 Controller생성
결승점 판단 객체 추가

##Step 4
Step3에서 개선점
1. sudo코드를 sketchTest를 작성 후 Class로 확장하는 개발 Outside In TDD 적용 
2. 기존 Car.RaceRecode를 제거 후 Car에 상태값을 가짐

##Step 3
#### 기능 흐름
자동차 안에는 자신의 진행 횟수 상태를 가지고 있다..
카레이스객체는 안에 List<자동차> 레이스 횟수가 있다.
자동차 대수 입력 받은 후 List<자동차> size를 초기화한다.
시도 할 횟수 입력 받은 후 레이스 객체에 변수로 입력한다.

각 라운드 마다 자동차 자신의 전진 함수를 실행하고 자신의 진행 상태를 출력한다.

주의 할 점  
3중첩 반복문이 나올 수 있다.   
레이스 시작전에 미리 값을 정해놓고 하는 방법도 있음

#### 기능 목록
* UI 로직
>>1.inputView  
>>2.resultView
* 전진조건 판단
>>1.난수로 4 이상 일경우 전진한다
* 값 입력
>>1.대수 회수 입력
