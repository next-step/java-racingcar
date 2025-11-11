package racingGame.Business;

import java.util.ArrayList;
import java.util.List;
import racingGame.model.Car;

public class CarFactory {
    
    private final List<Car> cars = new ArrayList<>();

    public List<Car> createCars(int carNumber) {
        validateCar(carNumber);
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    private void validateCar(int cars){
        if(cars < 1) {
            throw new IllegalArgumentException("참가시킬 자동차 수 입력이 생략되거나, 0이하");
        }
    }

}
