# Step 5 - 리팩토링

## **Step 4 에서 받은 피드백**

- `ResultView`에서만 쓰일 유틸은 따로 분리하기 보다 `ResultView`의 메소드로 리팩토링
  - 객체 응집성을 높힐 수 있음

~~~java
class Car {
  ...
   public Car getCar(int index){
      return cars.get(index);
   }
  ...
}
~~~

- 일급 컬렉션에 대해 get을 사용하면서 loop를 돌리기보다 이 로직을 일급 콜렉션 안으로 넣도록 라팩토링
  - `Cars`가 ArrayList면 좋겠지만, 만약 다른 List일 경우 오버헤드 발생할 수 있음.
  - 제안
    - `ResultView`에서 `List<Car> Cars`를 가지고 있고, `Car`는 name, score, symbol을 가져오는 불변 멤버와 `getter()`만 정의
    - 그냥 loop만 돌리는 `cars.getCar(iterator)`는 피하자
- 출력 결과에서 라운드 출력할때, `String.format()` 사용 추천
  - `System.out.println(String.format("[%d] round", i + 1)]);`
- <u>리턴 타입이 있는 메소드</u>는 **명사형**으로 리팩토링

## 진행상황

- [x] `ConvertToStringFromList()` 를 `ResultView` 메소드로 변경
- [x]  라운드 출력시 `String.format()`으로 코드 가독성 높힘.





