# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 계산기 요구사항 분석
 * 값을 입력받는다.  
 * 값을 자르기 전에 검증한다. (숫자 Space 연산자 Space 숫자 Space 연산자 Space 패턴) <- 연산자는 Enum 또는 상수로 관리해도 좋겠다.
 * split을 통해 문자열을 자른다.  
 * 값을 검증한다. ("/" 바로 뒤에 0이 오는 경우)  
 * 값이 제대로 입력되지 않았을 경우 Exception을 도출한다.  
 * 값이 제대로 입력되었을 경우, 앞에서 부터 계산을 수행한다.  
    
## 요구사항 분석 과정

```
* 초간단 자동차 경주 게임을 구현한다.  
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.  
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.  
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.  
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.  
```

```
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외  
  * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.  
  * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.  
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.  
  * 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
* else 예약어를 쓰지 않는다.
  * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
```
### 동작 Flow

1. 자동차 대수를 입력받아 저장한다.  
2. 시도할 횟수를 입력받아 저장한다.  
3. 자동차 별 랜덤 수를 추출하여 갖는다.  
4. 해당 랜덤 수가 4 이상의 경우 전진 true 값을 갖는다.  
5. 전진할 수 있는 경우 '-'를 출력한다. 

### 구현에 대한 구상  

> **도출된 클래스**  
> RacingGame, Car, InputView, ResultView, CarRound, GameRule

1. 자동차라는 클래스를 생성하여 랜덤 수와 전진 여부 값을 가지고 있도록 하자.  
2. 그때 그때 출력해도 좋고, 자동차 자체에 전진 수를 가지고 있어서 마지막에 출력해줘도 좋을 듯 하다.  
3. UI 로직은 InputView와 ResultView 클래를 추가해 분리한다.  
4. Rendom수를 생성한다는 개념을 게임의 룰로 생각하여 GameRule 클래스 생성

#### 필요 메서드  

1. 랜덤 수를 뽑아주는 메서드 - Car
2. 전진 여부를 결정해주는 메서드  - Car
3. 자동차 객체를 입력받은 대수만큼 생성해주는 메서드 - Racing Game  

#### 고민되는 점  

- 자동차별로 몇 회차에 전진 여부 정보를 모두 관리할 필요가 있을까?  
-> 결과를 매 회차별로 출력을 해준다면 필요할 것 같다. -> 회차 정보를 관리할 클래스가 필요하다. -> CarRound
- 각 회차별 자동차의 Position 정보를 RacingGame이 가지고 있어야 할까, Car가 가지고 있어야 할까?  
-> RacingGame 내에서는 각 회차별 Car 정보를 가지고 있고, Car 안에는 각 회차별 랜덤 수를 가지고 있자.  
-> RacingGame 내에 각 회차별로 Car의 랜덤수를 가지고 와서 전진 여부를 결정하는 API를 추가해서 가지고 있자.  
- Validation 할 것들이 있을까? 
    - 차 대수가 0이하이면 안된다.  
    - 회차 수가 0이하이면 안된다.  
    - 랜덤 수가 0-9 사이여야 한다.  
- 게임 결과 클래스도 도출해볼까?  
    - 코드 상에서 게임 결과 정보에 대한 명확한 정의가 없으니 보기 힘들지 않을까? 
    - 마찬가지로 ResultView로 결과 값을 넘겨주는 게 아니라 실질적인 결과인 carList를 넘겨주는데, 이게 코드상으로 봤을 때 명확해보일까?  
 