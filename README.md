# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 목록
1. 자동차 수 입력
2. 이동 횟수 입력 
3. 전진 기능 (random 함수 이용) 
4. 자동차 상태 출력
5. 단위 테스트
    * 전진
    * 멈춤
    
## 학습 내용
### 추상 메소드
자식 클래스에서 반드시 오버라이딩해야만 사용할 수 있는 메소드

    abstract 반환타입 메소드이름();
### 추상 클래스 
하나 이상의 추상 메소드를 포함하는 클래스<br/>
객체 지향 프로그래밍에서 중요한 특징이 다형성을 가지는 메소드의 집합을 정의할 수 있도록 한다.<br/>
즉, 반드시 사용되어야 하는 메솓를 추상 클래스에 추상 메소드로 선언하면, 이 클래스를 상속받는 모든 클래스에서는 이 추상 메소드를 반드시 재정의해야 한다. 

    abstract class 클래스이름 {
        ...
    
        abstract 반환타입 메소드이름();
    
        ...
    }

사용 이유: 추상 메소드가 포함된 클래스를 상속받는 자식 클래스가 반드시 추상 메소드를 구현하도록 하기 위함이다.<br/>
추상 메소드가 포함된 추상 클래스를 상속받은 모든 자식 클래스는 추상 메소드를 구현해야만 인스턴스를 생성할 수 있다.

***

### 함수형 인터페이스 (Functional Interface)
1개의 추상 메소드를 갖고 있는 인터페이스<br/>
아래와 같은 인터페이스를 함수형 인터페이스라고 한다.

    public interface FunctionalInterface {
        public abstract void doSomething(String text);
    }
    
사용 이유: 자바의 람다식은 함수형 인터페이스로만 접근 가능<br/>
다음과 같은 방식으로 사용 가능하다.

    public interface FunctionalInterface {
         public abstract void doSomething(String text);
    }
    
    FunctionalInterface func = text -> System.out.println(text);
    func.doSomething("do something");

#### 기본 함수형 인터페이스
자바에서 기본적으로 제공하는 함수형 인터페이스는 다음과 같다.
- Runnable
- Supplier
- Consumer
- Function<T, R>
- Predicate
 
###### Runnable
인자를 받지 않고 리턴값도 없는 인터페이스

    public interface Runnable {
      public abstract void run();
    }
    
    /* 사용 에시 */
    Runnable runnable = () -> System.out.println("run anything!");
    runnable.run();
    // 결과
    // run anything!
    
###### Supplier<T>
인자를 받지 않고 T 타입의 객체를 리턴

    public interface Supplier<T> {
        T get();
    }
    
    /* 사용 예시 */
    Supplier<String> getString = () -> "Happy new year!";
    String str = getString.get();
    System.out.println(str);
    // 결과
    // Happy new year!
    
##### Consumer<T>
T 타입의 객체를 인자로 받고 리턴 값은 없다.

    public interface Consumer<T> {
        void accept(T t);
    
        default Consumer<T> andThen(Consumer<? super T> after) {
            Objects.requireNonNull(after);
            return (T t) -> { accept(t); after.accept(t); };
        }
    }
    
    /* 사용 예시 */
    Consumer<String> printString = text -> System.out.println("Miss " + text + "?");
    printString.accept("me");
    // 결과
    // Miss me?
    
##### Function<T, R>
T 타입의 인자를 받고, R 타입의 객체를 리턴

    public interface Function<T, R> {
        R apply(T t);
    
        default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
            Objects.requireNonNull(before);
            return (V v) -> apply(before.apply(v));
        }
    
        default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
            Objects.requireNonNull(after);
            return (T t) -> after.apply(apply(t));
        }
    
        static <T> Function<T, T> identity() {
            return t -> t;
        }
    }
    
    /* 사용 예시 */
    Function<Integer, Integer> multiply = (value) -> value * 2;
    Integer result = multiply.apply(3);
    System.out.println(result);
    // 결과
    // 6
    
##### Predicate<T>
T 타입 인자를 받고 결과로 boolean을 리턴

    public interface Predicate<T> {
        boolean test(T t);
    
        default Predicate<T> and(Predicate<? super T> other) {
            Objects.requireNonNull(other);
            return (t) -> test(t) && other.test(t);
        }
    
        default Predicate<T> negate() {
            return (t) -> !test(t);
        }
    
        default Predicate<T> or(Predicate<? super T> other) {
            Objects.requireNonNull(other);
            return (t) -> test(t) || other.test(t);
        }
    
        static <T> Predicate<T> isEqual(Object targetRef) {
            return (null == targetRef)
                    ? Objects::isNull
                    : object -> targetRef.equals(object);
        }
    }
    
    /* 사용 예시 */
    Predicate<Integer> isBiggerThanFive = num -> num > 5;
    System.out.println("10 is bigger than 5? -> " + isBiggerThanFive.test(10));
    // 결과
    // 10 is bigger than 5? -> true
    
### 전략 패턴 (Strategy Pattern)
객체가 할 수 있는 행위를 각각 전략 클래스로 생성하고, 유사한 행위들을 캡슐화하는 인터페이스를 정의하여, 동적으로 행위의 수정이 필요한 경우 전략을 바꾸는 것만으로도 행위의 수정이 가능하도록 만든 패턴 <br/>
즉, 프로젝트 전체에서 변경이 일어나지 않는 부분에서 변경이 일어나는 부분을 찾아서 따로 캡슐화한다.

장점
- 코드 중복 방지
- 런타임 시에 타겟 메소드 변경
- 확장성(신규 클래스) 및 알고리즘 변경 용이 

[참고 예제 사이트] https://victorydntmd.tistory.com/292


