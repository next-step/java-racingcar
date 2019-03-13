package racing;

import java.util.*;

public class RacingGame {

    public static int generateRandomValue() {
        return new Random().nextInt(10);
    }

    public static List<Car> race(List<Car> cars) {
        for(Car car : cars) {
            car.move(generateRandomValue());
        }
        return cars;
    }


    public static List<Car> initCars(int numberOfCar) {
        List<Car> cars = new ArrayList<Car>(numberOfCar);
        for(int i = 0 ; i < numberOfCar ; i++){
            cars.add(i, new Car());
        }
        return cars;
    }


}
