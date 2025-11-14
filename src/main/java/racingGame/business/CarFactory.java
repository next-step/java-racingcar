package racingGame.business;

import java.util.ArrayList;
import java.util.List;
import racingGame.model.Car;

public class CarFactory {
    
    public static List<Car> createCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        validateCar(names.length);
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void validateCar(int cars){
        if(cars < 1) {
            throw new IllegalArgumentException("참가시킬 자동차 수 입력이 생략되거나, 0이하");
        }
    }

}
