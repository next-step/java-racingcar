package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingManager {

    private List<Car> ragingCarList = new ArrayList<>();

    public void startRacing() {
        for (Car car : ragingCarList) {
            moveRacingCar(car);
        }
    }

    private void moveRacingCar(Car car) {
        if (canMoveCar(getRandomNumber())) {
            car.moveCar();
        }
    }

    public void makeRacingCar(int numberOfCar) {
        for (int i = 0; i < numberOfCar; i++) {
            ragingCarList.add(new Car());
        }
    }

    public boolean canMoveCar(int randomNumber) {
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public List<Car> getCarList() {
        return this.ragingCarList;
    }
}
