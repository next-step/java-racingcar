package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {

    public List<Car> createCars(int size) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            cars.add(new Car());
        }
        return cars;
    }


    public void activeTurns(List<Car> cars, int turn) {
        for (int i = 0; i < turn; i++) {
            this.activeCars(cars);
        }
    }

    protected void activeCars(List<Car> cars) {
        Random random = new Random();
        for (Car car : cars) {
            car.active(canProgress(random.nextInt(10)));
        }
    }

    public static boolean canProgress(int randomNumber) {
        return randomNumber >= 4;
    }
}
