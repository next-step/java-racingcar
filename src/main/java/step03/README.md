## 목표
초간단 자동차 경주 게임 구현

## 기능 목록 및 commit 로그 요구사항
기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.

### 1차 기능 목록
1. [x] 입력 하는 기능(InputView)
    - 자동차 대수 numberOfCars
    - 이동 횟수 numberOfMoves
1. [x] 자동차의 process 를 화면에 출력하는 기능 (ResultView)
    
1. [x] 입력값이 0 이하 이면 예외를 일으키는 기능과 테스트
1. [x] 0 에서 입력한 값 사이에서 정수 random 값을 반환하는 기능과 테스트


### Main
1. 자동차 대수, 이동 횟수 입력 하는 기능(InputView)
1. 자동차 대수, 이동 횟수 입력값이 각각 0 일 때 예외를 일으킵니다.
1. 이동 횟수만큼 반복문을 수행
    - 각 자동차별 0 ~ 9 사이의 랜덤 값을 발생 
    - 발생한 랜덤값이 4 이상일 경우 전진하고 미만일 경우 해당 횟수에서 정지한다.
    - 각 자동차의 동작을 결정한 후 화면에 반영합니다.

## 2차 
준일님께 피드백을 받았다. 

- Operate 클래스 에서 Cars 클래스와 Car 클래스의 분리
- car 의 이동 동작도 외부에서 주입을 시켜주는 방식
- 이동 동작을 strategy 패턴을 사용해 인터페이스로 구현
- of 패턴, new 사용은 지양

Operate 를 만들다가 키보드를 빼앗기고 아주 혼났다.. 느낀점은

- 경기 운영이라는 Class 만 초기에 만들다가 준일님의 피드백 후, 자동차들 Cars, 와 자동차 Car 클래스도 만들어야 한다는 피드백을 받고.
문제가 주어질 때 객체를 찾아내는 것과, 객체가 하는 동작을 메서드로 정의하는 것을 유의해야 겠다. 그리고 클래스와 - 클래스를 묶는 단위도 클래스로 고려한다는것.

## 기능목록 정리
1. InputView 클래스
    - 자동차 대수 numberOfCars
    - 이동 횟수 numberOfMoves 
    - 를 입력하는 기능
1. ResultView 클래스
    - 자동차의 현재 위치들을 출력하는 기능의 print 클래스 메서드
1. Validator 클래스
    - 입력값이 0 이하 이면 예외를 일으키는 기능의 validatePositiveNumber 클래스 메서드
1. RandomGenerator 클래스
    - 0 에서 입력한 값 사이에서 정수 random 값을 반환하는 기능의 ZeroToPositiveIntGenerate 클래스 메서드
1. MoveStrategy 인터페이스, extends 한 랜덤으로 이동을 하는 RandomMoveStrategy 클래스 
1. Car 클래스
   - '-' 를 나타내는 position 멤버변수
   - of 생성자
   - 단일 자동차를 움직여 '-' 를 증가시키는 move 인스턴스 메서드
   - position을 반환하는 인스턴스 메서드
1. feat: Cars 클래스 
    - Car 를 List 로 가지고 있는 멤버변수 cars 
    - cars 를 carNumbers 혹은 List<Car> cars 를 생성자의 매개변수로 다형성 
    - cars 를 모두 이동시키는 move 인스턴스 메서드 
    - cars 의 상태를 출력하는 show() 메서드
1. Operator 클래스
    - 경기를 운영하는 기능
    - 경기횟수, 자동차 갯수를 혹은 경기횟수, 참가하는 자동차 들을 생성자의 매개변수로 받는다.
    - operate 인스턴스 메서드는 경기횟수만큼 자동차를 이동시킨다
1. Main 클래스
    - 앱을 실행하는 기능

### [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
git 의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
```
feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain)
```

## [자바 코드 컨벤션 리팩토링](https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596)

## 카피
- 오태경님 리뷰 중
```
getter를 안쓰기 위해 함수형을 사용해주신 것 같네요 👍

개인적으로는 getter는 없을 수 없다고 생각해요 (setter는 없을 수 있다고 생각합니다!)
해당 규칙이 전하고자 하는 의미는 객체 스스로가 데이터와 행위를 다루도록하여 자율적인 객체를 만드는것이라고 생각해요! 즉, 상태를 가지는 객체를 설계를 했다면 데이터를 노출시켜 로직을 처리하도록 구현하지 말고
해당 객체에 메시지를 보내 그 객체 스스로가 일을 할 수 있도록 설계 하라는 의미로 생각합니다.

출력을 해야된다면 getter를 사용해도 된다고 생각해요 😄
시윤님께서 말씀해주신것처럼 DTO는 객체가 아니기에 getter / setter를 사용해도 상관없다고 생각합니다!
```

