# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## TODO
* 초간단 자동차 경주 게임을 구현한다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
---
## TODO 분석
* 사용자는 / 몇 대의 자동차로 / 몇 번의 이동을 할 것인지를 / 입력할 수 있어야 한다.
    * 몇 대의 자동차를 입력 받는다.
    * 몇 번의 이동을 할 것인지를 입력 받는다.
* 전진하는 조건은 / 0에서 9 사이에서 / random 값을 구한 후 / random 값이 4이상일 경우이다.
    * random 값은 0 ~ 9 사이이다.
    * random 값을 구한다.
    * random 값이 4 이상일 경우 전진한다.
    * random 값이 4 미만일 경우 멈춘다.
* 주어진 횟수 동안 / n 대의 자동차는 / 전진 또는 / 멈출 수 있다.
    * 한번의 횟수 동안 1 대의 자동차는 전진 / 멈춤
    * 한번의 횟수 동안 n 대의 자동차는 전진 / 멈춤 
    * 주어진 횟수 동안 1 대의 자동차는 전진 / 멈춤
    * 주어진 횟수 동안 n 대의 자동차는 전진 / 멈춤
* 자동차의 상태를 화면에 출력한다. / 어느 시점에 출력할 것인지에 대한 제약은 없다.
    * 자동차의 상태를 화면에 출력한다.
---
## 테스트 가능한 기능별 분리(실제 단위 테스트 코드 모듈)
* 테스트하기 쉬운 요구사항(입력과 출력이 확실한 util 성격의 기능)
    * ~~number 값은 0 ~ 9 사이이다.~~
    * ~~자동차는 한번의 이동 횟수 동안 number 값이 4 이상일 경우 전진한다.~~
      * ~~number 값이 4 이상일 경우 전진한다.~~
    * ~~자동차는 한번의 이동 횟수 동안 number 값이 4 미만일 경우 멈춘다.~~
      * ~~number 값이 4 미만일 경우 멈춘다.~~
    * ~~자동차의 주어진 이동 횟수 동안 (전진/멈춤) 상태를 저장한다.~~
    * ~~자동차들의 주어진 이동 횟수 동안 (전진/멈춤) 상태를 저장한다.~~
    * ~~몇 대의 자동차를 입력 받는다.~~
      * ~~자동차의 갯수는 최소 1대 이상이다.~~
    * ~~몇 번의 이동을 할 것인지를 입력 받는다.~~
      * ~~이동은 최소 1번 이상이다.~~
    * ~~자동차의 상태를 화면에 출력한다.~~
      * ~~자동차의 상태를 문자열로 출력한다.~~
      * ~~자동차들의 상태를 문자열로 출력한다.~~
      * ~~경기실행 결과를 문자열로 출력한다~~
* 테스트하기 힘든 요구사항(view, random number...)
    * ~~random 값을 구한다.~~
    * ~~자동차의 상태를 화면에 출력한다.~~
    * ~~몇 대의 자동차를 입력 받는다.~~
    * ~~몇 번의 이동을 할 것인지를 입력 받는다.~~

## 기능 개선사항
```java
public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        ResultView resultView = new ResultView(inputView.carNumber(), inputView.movement());
        resultView.print();
    }
}
```
* ResultView 는 콘솔에 요구사항대로 출력하는 역할만 담당하게 한다.
  * 이미 RacingGame 이라는 객체가 정의되어 있다.
  * RacingGame 을 통해서 출력에 필요한 정보를 받는다.
  * 나머지는 ResultView 쪽으로 역할과 책임을 위임한다.
    * RacingGame 의 실행역할 까지 가져갈 필요는 없다.
```java
public class RacingGame {
    private final PositiveNumber carSize;
    private final PositiveNumber movement;
}
```
* 비즈니스 요건을 적용하다보면 carSize와 movement에 다른 조건의 validation들이 적용되어야 할 수도 있다.
  * CarSize, Movement와 같은 식으로 원시객체가 포장되는것도 하나의 방법이 될 수 있다.
  * https://velog.io/@kanamycine/Java-%EC%9B%90%EC%8B%9C%EA%B0%92-%ED%8F%AC%EC%9E%A5
```java
public class RacingGame {
    //...
    public String runAndResult(NumberCreator numberCreator) {
        Cars cars = createCars();
        StringBuilder movementStatusesResult = new StringBuilder();
        for (int index = 0; movement.isGreaterThan(index); index++) {
            cars.moveAll(numberCreator);
            movementStatusesResult.append(statusesResult(cars, index));
        }
        return movementStatusesResult.toString();
    }
    //...
}
```
* RacingGame runAndResult 메서드
  * 이 부분은 ResultView와의 결합도가 높은 부분인 것 같다. 
  * 만약 RacingGame을 가지고 웹으로 부터 입출력을 하는 어플리케이션을 만든다면,
  * 이 부분은 계속 수정이 발생할 수 밖에 없는 구조. 
  * 또한 콘솔이라고 할지라도 콘솔에 출력 형식이 변경 된다거나,
  * 출력 형식에 대한 요구사항이 생긴다면,
  * 비즈니스 요구사항과는 상관없이 계속적으로 수정이 발생해야 할 부분.
```java
public enum Status {
    FORWARD("-"), STOP("");
  //...
}
```
* Status에 대해서도
  * 출력 format이 변경 될 경우 Enum도 계속 수정이 될수밖에 없다.
  * (예를 들어 -가 *, =등으로 변경된다고 가정하면)
```java
public class Car {
    //...
    public void move(ForwardNumber forwardNumber) {
        //...
    }
    //...
}
```
* Car를 move시키려면 ForwardNumber 외에는 방법이 없는 구조 
  * 이 부분을 좀 더 유연하고 확장성 있게 변경하면 좋을 것 같다. 
    * 지금 구조라면, 특정 조건이 있을 때만 차를 전진시킨 다든지, 
    * 혹은 Racing 경기 중 사고가 발생해서 사고난 차 이외의 차들을 멈추게 한다든지 하는, 
    * 숫자가 아닌 조건에 대한 Car 변경의 요건을 반영하기가 좀 까다롭다.
    * 향후 발생할 수정사항이나 확장성에 대해서 조금더 유연한 구조를 가져가도록 개선

```java
public class Car {
    public String currentStatus() {
        return this.statuses
                .stream()
                .map(Status::printStatus)
                .collect(Collectors.joining());
    }
}
```
* 위에서도 의견드렸지만 출력에 필요한 정보를 제공하는 건 좋지만, 
  * 출력 format까지 Car가 담당한다면 출력 format 때문에 계속적인 수정이 발생 
```java
public class Cars {
    public void moveAll(NumberCreator numberCreator) {
        
    }
}

```
* moveAll 네이밍 크게 나쁘지 않은 것 같음
  * 아주 소소한 의견이긴 합니다만 개인적으로 Cars가 정의가 된 코드가 아닌
  * Cars를 사용하는 쪽 입장에서 혼동을 줄이는 편이 더 나은 방향
  * 복잡한 코드를 따라가다 보면 원래 형을 확인 하는게 번거로움 
  * 예를들어,
```
// 만약 실수로 number라고 변수명을 지었을 때, number의 형을 확인하기 전까지는 일반 숫자라고 착각할 수도 있습니다.
cars.moveAll(number);

// 이렇게 된다면 변수명을 아무렇게나 지어도 creator에 의한 move all 이구나 추측이 가능합니다.
cars.moveAllByNumberCreator(number);
```

```java
public enum Status {
    FORWARD("-"), STOP("");
    private final String printStatus;

    Status(String printStatus) {
        this.printStatus = printStatus;
    }

    public static Status extractByNumber(ForwardNumber number) {
        if (number.isForwardNumber()) {
            return FORWARD;
        }
        return STOP;
    }
}
```
* Enum 고유의 비즈니스 로직이라면 Enum이 역할을 가져가도 될 것 같다. 
  * isForwardNumber인지를 판단해서 FORWARD 할지, STOP 할지는 
  * 비즈니스 로직을 담당하는 객체가 역할을 가져가는게 맞을 것 같음
* Enum은 기본적으로 상수들의 집합 
  * 지금 구조에서는 특정 값을 Enum으로 변환하거나 
  * Enum을 속성 값으로 변환하는 printStatus() 같은 method 정도만 제공하면 충분

```java
@FunctionalInterface
public interface NumberCreator {
  int number(Car car);
}
```
* 어색했던 부분.
  * NumberCreator인데 그럼 숫자를 생성하는 역할을 담당하는 객체인데, 
  * Car는 왜 필요한걸까?
  * 그리고 실제 비즈니스를 구현한 RandomNumberGenerator를 봐도 Car는 사용하지 않고 있다. 
  * 이렇게 되면 나중에 Car가 수정되었을 때 전혀 관련이 없는 NumberCreator들 까지 수정 영향이 있는지 확인해야 하는 번거로움도 발생. 

```java
public class RandomNumberGenerator implements NumberCreator {

    @Override
    public int number(Car car) {
        return new Random().nextInt(10);
    }
}
```
* 매번 Random객체를 생성하지 않도록 정적상수로 추출 
  * 10도 매직넘버 이니 추출