# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)







## 문자열 계산기

#### 요구 사항

- [x] 계산하는 클래스 만들기
  - [x] 덧셈
  - [x] 뺄셈
  - [x] 나눗셈
  - [x] 곱셈

- [x] 사용자 문자열 처리 클래스
  - [x] 입력 받고
  
  - [x] 입력 값 검증
    - 입력값이 null이거나 빈 공백 문자일 경우, IllegalArgumentException throw
    - 사칙연산 기호가 아닌 경우, IllegalArgumentException throw
    
  - [x] 문자열 파싱
  
    - "2  + 3 * 4 / 123" > 
  
    - 입력 조건
  
        1. 계산이 가능한 형식
      2. 단, 공백은 처리 가능(연속 공백도 허용)
     - 결과 값    
         1. 정수로 반환



#### Feedback

> - 피드백 반영하기
> - 기능과 로직이 명확하게 보일 수 있도록 리팩토링

###### 1. 네이밍

- [x]  StringProcessor인데 `play`라고 변수명을 지으신 이유가 있을까요?
- [x]  `getInput()`인데 값을 get하지 않고 있어요! 조금 더 좋은 네이밍을 생각해보면 어떨까요?
- [x]  `number1`, `number2` 보다 조금 더 의미있는 네이밍을 해보면 어떨까요?



###### 2. 기능 통합

- [x]  `getInput()`과 `checkInput()`을 하나로 합쳐보면 어떨까요?

- [x]  `parseInput()`과 `getResult()`를 분리하지 않고 parseInput의 결과로 result를 리턴하면 어떨까요?

  

###### 3. JAVA 컨벤션

- [x]  depth가 2를 초과한 것 같아요!! depth를 줄여보면 어떨까요?
- [x]  여기도 depth가 2를 초과한 것 같아요!!
- [x]  [매직넘버를 상수화](https://javabom.tistory.com/28)해보면 어떨까요?
- [x]  [String vs StringBuilder vs StringBuffer](https://velog.io/@dnjscksdn98/Java-String-vs-StringBuilder-vs-StringBuffer)를 읽어보시구 더 알맞은 방법을 찾아보면 어떨까요?
- [x]  `throws IllegalArgumentException`은 하지않아도 돼요!



###### 4. 테스트

- [x] [StirngProcessor] 요기 있는 모든 public메서드에 대한 테스트를 작성해보면 어떨까요?





## 자동차 경주 게임 

#### 요구사항
- [x] 자동차 이름을 입력한다.-GameInit
  - [x] 각 자동차 이름은 5글자를 초과할 수 없다.
  - [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
  - [x] 자동차는 자동차 이름과 위치 정보를 가지는 Car 객체를 추가해 구현한다. -Car
- [x] 몇 번의 이동을 할 것인지 입력한다.-GameInit
- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.-PlayGame
  - [x] 전진 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. -PlayGame
  - [x] 자동차의 상태를 화면에 출력한다.
  - [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  - [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.- PlayGame



#### Feedback

- [x]  isValidate자체가 boolean이기 때문에 아래와 같이 작성할 수 있을 것 같아요 :)
- [x]  불필요한 라인을 제거할 수 있을 것 같아요!
- [ ]  해당 함수를 private으로 만들고 `inputPlayerName()`을 테스트할 수는 없을까요?
- [x]  [정적 팩터리 메서드](https://tecoble.techcourse.co.kr/post/2020-05-26-static-factory-method/)를 이용해서 Cars객체를 생성할때 cars 필드들도 함께 set될 수 있게 만들어보면 어떨까요?
- [x]  carList가 아닌 Cars객체를 넘겨서 처리할 수 없을까요?



