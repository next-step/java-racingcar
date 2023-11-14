package step4;

import java.util.List;

public class Car {
    public String name;
    private int distance = 0;

    public Car(String carNames) {
        this.name = carNames;
    }

    public List<Car> generateCars() {
        return CarRacingUtil.splitCarNames(this.name);
    }

    public void addDistance(int randomNumber) {
        if (randomNumber >= 4) {
            distance++;
        }
    }

    public void move() {
        CarRacingUtil carRacingUtil = new CarRacingUtil();
        addDistance(carRacingUtil.getRandomNumber());
    }

    public int getDistance() {
        return distance;
    }
}
