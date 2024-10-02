package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {

    private int match;
    public static List<String> cars = new ArrayList<>();


    public static int getRandomValue() {
        return new Random().nextInt(10);
    }

    public String moveForward(String car, int randomValue) {
        if (randomValue >= 4) {
            return car.concat("-");
        }
        return car;
    }

    public List<String> getCars() {
        return cars;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    public int getMatch() {
        return this.match;
    }

    public void initializeCar(int carNum) {
        for (int i = 0; i < carNum; i++) {
            cars.add("-");
        }
    }

    public void startMatch() {
        if (match > 0) {
            moveForwardCars();
            match--;
        }
    }

    private void moveForwardCars() {
        cars.replaceAll(car -> moveForward(car, getRandomValue()));
    }

}
