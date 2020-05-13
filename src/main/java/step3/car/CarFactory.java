package step3.car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    private final int numberOfCars;


    private CarFactory(int numberOfCars) {
        validationCheck(numberOfCars);
        this.numberOfCars = numberOfCars;
    }

    public static CarFactory of(int numberOfCars){
        return new CarFactory(numberOfCars);
    }

    public List<Car> createCars(){
        final  List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(Car.of());
        }
        return cars;
    }

    private void validationCheck(int numberOfCars){
        if (numberOfCars < 0) {
            throw new IllegalArgumentException("자동차 대수는 음수를 입력할 수 없습니다.");
        }
    }
}
