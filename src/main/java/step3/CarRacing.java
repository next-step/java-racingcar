package step3;

import java.util.*;
import java.util.stream.Collectors;

public class CarRacing {

    public static final int RANDOM_RANGE = 10;

    private List<Car> cars;

    public CarRacing(List<Car> cars) {
        this.cars = cars;
    }

    public void createCars(int amountOfCar) {
        for (int i = 0; i< amountOfCar; i++) {
            this.cars.add(new Car(i));
        }
    }

    public void moveCars(int countOfCar) {
        System.out.println("\n실행 결과");
        Random random = new Random();

        for (int i = 0; i < countOfCar; i++) {
            moveCar(random.nextInt(RANDOM_RANGE));
            System.out.println();
        }
    }

    private void moveCar(int randomNumber) {
        cars.forEach(car -> {
            car.updateMove(randomNumber);
        });
    }
}