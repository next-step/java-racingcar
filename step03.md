## 목표
초간단 자동차 경주 게임 구현

## 기능목록 정리
1. InputView 클래스
    - 자동차 대수 numberOfCars
    - 이동 횟수 numberOfMoves 
    - 를 입력하는 기능
1. ResultView 클래스
    - ResultView::print 자동차의 현재 위치들을 출력하는 기능
1. Validator 클래스
    - Validator::validatePositiveNumber 입력값이 0 이하 이면 예외를 일으키는 기능
1. RandomGenerator 클래스
    - RandomGenerator::ZeroToPositiveIntGenerate 0 에서 입력한 값 사이에서 정수 random 값을 반환하는 기능
1. MoveStrategy 인터페이스, extends 한 랜덤으로 이동을 하는 RandomMoveStrategy 클래스 
1. Car 클래스
   - of 생성자
   - 자동차의 종류 carKind 를 생성자로 저장한다.
   - this::move 단일 자동차를 움직여 position 에 '-' 를 더하는 기능
   - this::position position 을 반환하는 인스턴스 메서드
1. Cars 클래스 
    - Car 를 List 로 가지고 있는 멤버변수 cars 
    - 생성자 다형성 
        - cars 를 carNumbers 혹은 List<Car> cars 매개변수로 생성
    - this::move, cars 의 car 의 move 메서드를 모두 호출시키는 기능 
    - this::show, cars 의 상태를 출력하는 기능
1. Operator 클래스
    - 경기를 운영하는 기능
    - 경기횟수(numberOfMoves), 참가하는 자동차들(Cars)을 생성자의 매개변수로 받는다.
    - this::operate, 경기회차마다 자동차를 이동시키는 기능
        - 출력할 자동차의 종류를 매개변수로 받는다.
        - 자동차를 옮길 기준이 되는 전략을 매개변수로 받는다.
        - 매 회차마다 전략에 따른 자동차를 이동시킨다.
        - 매 회차마다 경주결과를 출력한다.
1. Main 클래스
    - 앱을 실행하는 기능

## Main
1. 자동차 대수, 이동 횟수 입력 하는 기능(InputView)
1. 자동차 대수, 이동 횟수 입력값이 각각 0 일 때 예외를 일으킵니다.
1. 이동 횟수만큼 반복문을 수행
    - 각 자동차별 0 ~ 9 사이의 랜덤 값을 발생 
    - 발생한 랜덤값이 4 이상일 경우 전진하고 미만일 경우 해당 횟수에서 정지한다.
    - 각 자동차의 동작을 결정한 후 화면에 반영합니다.
    
## 기능 구현
기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.

### 1차
1. 입력 하는 기능(InputView)
    - 자동차 대수 numberOfCars
    - 이동 횟수 numberOfMoves
1. 자동차의 process 를 화면에 출력하는 기능 (ResultView)
    
1. 입력값이 0 이하 이면 예외를 일으키는 기능과 테스트
1. 0 에서 입력한 값 사이에서 정수 random 값을 반환하는 기능과 테스트


### 2차 
준일님께 피드백을 받았다. 

- Operate 클래스 에서 Cars 클래스와 Car 클래스의 분리
- car 의 이동 동작도 외부에서 주입을 시켜주는 방식
- 이동 동작을 strategy 패턴을 사용해 인터페이스로 구현
- of 패턴, new 사용은 지양

Operate 를 만들다가 키보드를 빼앗기고 아주 혼났다.. 느낀점은

- 경기 운영이라는 Class 만 초기에 만들다가 준일님의 피드백 후, 자동차들 Cars, 와 자동차 Car 클래스도 만들어야 한다는 피드백을 받고.
문제가 주어질 때 객체를 찾아내는 것과, 객체가 하는 동작을 메서드로 정의하는 것을 유의해야 겠다. 그리고 클래스와 - 클래스를 묶는 단위도 클래스로 고려한다는것.

### 3차
준일님의 추천으로 [8기 gmlwjd9405 님의 PR](https://github.com/next-step/java-racingcar/pull/774) 을 보았습니다.

- 테스트 케이스를 보며 내 코드에서 만들 수 있는 테스트 케이스에 대한 도움을 얻었다.

## ohtaeg 님 리뷰 
```
getter를 안쓰기 위해 함수형을 사용해주신 것 같네요 👍

개인적으로는 getter는 없을 수 없다고 생각해요 (setter는 없을 수 있다고 생각합니다!)
해당 규칙이 전하고자 하는 의미는 객체 스스로가 데이터와 행위를 다루도록하여 자율적인 객체를 만드는것이라고 생각해요! 즉, 상태를 가지는 객체를 설계를 했다면 데이터를 노출시켜 로직을 처리하도록 구현하지 말고
해당 객체에 메시지를 보내 그 객체 스스로가 일을 할 수 있도록 설계 하라는 의미로 생각합니다.

출력을 해야된다면 getter를 사용해도 된다고 생각해요 😄
시윤님께서 말씀해주신것처럼 DTO는 객체가 아니기에 getter / setter를 사용해도 상관없다고 생각합니다!
```

### vagabond95 님 리뷰
```
Car 클래스에 대한 역할이 무엇인지, 이 역할로 미루어봤을 때 자동차의 움직임을 표현하는 데이터를 Car 클래스에서 가지고 있는 것이 적절할지 고민해보시면 좋을 것 같습니다.
'움직였을 때 "-" 로 표현해준다.' 라는 명세는 View 와 큰 연관이 있지 않을까요? 만약 움직임을 표현하는 기호가 바뀌면 Car 클래스에서 변경이 발생해야하는데 이는 적절할까요?
```
경기를 운영할 때마다 자동차의 종류를 지정해주는 것보다 view 에서 자동차의 종류를 지정하는 것이 더 쉽다는 생각이 들어 수정했습니다.

```
자동차의 움직임은 '랜덤한 값' 에 의해 결정이 되는데요,
랜덤한 값은 결과를 예측할 수 없기 때문에 테스트가 불가능한 영역에 속합니다.

랜덤한 값, 네트워크 환경, 시간 등 테스트 환경에서 항상 동일한 결과를 보장하기 어려운 요소들이 등장할때가 있는데요, 보통 이러한 케이스에서는 어려운 요소를 외부로 분리하여 외부에서 조작 가능한 형태로 바꾸는 방법을 취하고 있습니다.

좀 더 자세히 얘기해보면
사실 '자동차 입장' 에서는 랜덤하게 움직이든, 항상 움직이든 어떤방식으로 움직이는지는 관심이 없습니다. 그냥 내가 움직일 수 있는지 여부만 알면됩니다. 그럼 '움직임을 결정' 하는 부분을 외부에서 결정하고, 실제 테스트는 외부에서 의도한 값을 주었을 때 의도한 결과를 수행하는지만 확인해보면 되지 않을까요~?
```

### slamdunk7575 님 리뷰
```
README.md 파일은 소스코드 파일(src, test)과 같이 두시면 안됩니다. 삭제 부탁드립니다!
프로젝트 제일 바깥에 있는 하나의 파일로 스텝 별로 기록하시고 관리하시면 됩니다.
```

### enemfk777 님 리뷰
```
아래와 같은 순서로 키워드를 적어 두는 것이 Java Convention이랍니다 :)

Annotations
public
protected
private
abstract
static
final
transient
volatile
synchronized
native
strictfp
```
```
테스트 코드를위한 public 메서드를 만들어 두신 것 같네요 :)
프로덕션 코드에서는 불필요하고, 테스트코드만을 위한 접근 제한자 선언은 지양하시는게 좋습니다.
private 메서드의 테스트가 꼭 필요해 보인다면, 클래스 분리를 해야하는 것은 아닌지 고민해 보시는건 어떨까요? 😊
```

### vagabond95 님 리뷰

```
테스트 코드 네이밍을 짓는 접근 방법은 여러가지로 논의되고 있는데요,

가독성을 위해 영어 혹은 한글로 통일된 규칙을 가지면 좋을 것 같습니다 :)

추가로 많이 사용되고 있는 테스트 코드 네이밍 컨벤션도 같이 참고해보시면 도움이 되실 것 같습니다!
```
(네이밍 컨벤션)[http://blog.naver.com/PostView.nhn?blogId=genycho&logNo=220317775484&parentCategoryNo=&categoryNo=73&viewDate=&isShowPopularPosts=true&from=search]

1. { 메소드명 }_{ 테스트하려는상태 }_{ 기대하는동작 }
2. { 메소드명 }_{ 기대하는동작 }_{ 테스트하려는상태 }
3. test{ 테스트하려는 기능 }
4. { 테스트하려는 기능 }
5. Should_{ 기대하는 동작 }_When_{ 테스트 대상 상태 }
6. When_{ 테스트 대상 상태  }_Expect_{ 기대하는 동작  }
7. Given_{ 사전조건 }_When_{ 테스트 대상 상태 }_Then_{ 기대하는 동작 }

```
내부 구현 로직에서 scanner 가 사용되어 메소드 이름에 scan 을 넣어주신 것으로 보이는데요,
이렇게 되면 scanner 가 아닌 다른 구현체가 사용될 경우 또 메소드의 이름에 변경사항이 발생하게 됩니다.

내부 구현 내용을 드러내지 않도록 메소드 네임을 변경해볼 수 있을까요?

(추가로 외부에서 접근할 수 있는 메소드의 네이밍에 구체적인 구현내용이 포함되지 않는 것도 '캡슐화'의 일종이라고 할 수 있습니다!)
```

```
메소드 네이밍은 동사형으로 시작하는 것을 권장
```
```
더 역할에 맞게 클래스 이름을 구체화
```

[God object](https://en.wikipedia.org/wiki/God_object)
- 객체지향 프로그래밍에서, 안티패턴 중 하나로.
- `knows too much or does too much.` 너무 많이 알거나 너무 많은 일을 하는 객체
- divide and conquer strategy !
- Single-responsibility principle !

[utill class anti pattern](https://ralin.io/blog/oop-anti-patterns-utility-or-helper-classes.html)

객체에 대한 검증은 객체 스스로 해야되며 검증 validate 의 기능을 바꾸기 위해서는 상속 의 방식을 택해야 한다. 

어떤 변수를 하나의 클래스를 거쳐 또다른 클래스로 이동을 해주어야 한다면, 중간 클래스가 그 변수를 알아야 할 까 ? 생각을 해야 한다.

생성자에서 생성하는 변수는 상수로 관리 되면 좋다.

**같은 동작으로 동일하게 사용 되는 변수가 매 번 만들어진다면 생성자를 사용해 보자.**

Car 클래스에 `default 멤버변수 값`을 정하는 것 괜찮은 건가?
- 고민한 이유, default 멤버 변수가 늘어날 수록 만들어야 하는 생성자의 수는 2 의 제곱으로 늘어난다.
 -> 한 클래스 멤버변수는 3개이상 쓰지 않는 것 이 좋다.

하지만 default 멤버변수 값` 인한 두 번째 문제는,
-
- Cars 클래스 역시 default 를 가지는 속성을 생성자 매개변수로 받아오기 때문에, 
- Car 인스턴스를 만드는 Cars 클래스 에서도 그 만큼의 생성자를 만들어 줘야 하는 문제점이 있었다.

이 방법이 썩 좋아 보이지는 않네요.. 객체의 책임과 역할을 지정하는 일이 아직은 힘든 것 같습니다. 

이에 Default 상수를 정의하는 생성자는 없앴습니다. 

[stream to for loop?](https://homoefficio.github.io/2016/06/26/for-loop-%EB%A5%BC-Stream-forEach-%EB%A1%9C-%EB%B0%94%EA%BE%B8%EC%A7%80-%EB%A7%90%EC%95%84%EC%95%BC-%ED%95%A0-3%EA%B0%80%EC%A7%80-%EC%9D%B4%EC%9C%A0/)
java 의 `stream 의 forEach`, `for 문`을 비교해 본 적이 없었기 때문에, 성능 차이가 별로 없고 함수형 프로그래밍은 가독성이 더 좋으므로 스트림을 써야한다고 생각 하고 있었습니다.
위 글을 읽고 난 후, `stream 의 forEach`, `for 문` 의 성능은 같지 않다는 이야기와, forEach 의 가독성이 항상 좋은 것은 아니라는 것을 알게 되었고.   
무분별하게 stream forEach 를 사용하는 것에 대한 경계를 일깨워 준 것 같습니다!  

```
랜덤 값은 테스트 수행 시마다 다른 결과를 반환하기에 테스트를 시도하는 의미가 없다고 생각되요.
우리가 암묵적으로 제한된 범위 내에서 반환될 것이라고 기대할 수 는 있어도 기본적으로 랜덤값이라는 특성상 다음 테스트 시에도 동일할 것이라는 보장이 안되기 때문입니다!

그래서 이러한 부분을 테스트할 수 없기 때문에, 적용해주신 전략패턴 등을 이용하여 동작을 분리하고 통제할 수있는 결과를 반환하도록 하여 테스트가 진행 가능하도록 접근하고 있습니다 :)
```


## [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
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


