package racingCar.step4;

public class Car {
    private final String name;
    public Car(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 입력 가능합니다");
        }
        this.name = name;
    }
}
