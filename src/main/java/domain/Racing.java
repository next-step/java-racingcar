package domain;

import java.util.ArrayList;
import java.util.Random;

public class Racing {
    private ArrayList<Car> carsList;
    private int stages;

    public Racing(ArrayList<Car> carsList, int stages) {
        this.carsList = carsList;
        this.stages = stages;
    }

    public void moveCars() {
        for (Car car : carsList) {
            decideMove(car);
            this.lowerStage();
        }
    }

    public ArrayList<Car> getCarsList() {
        return this.carsList;
    }

    public boolean isEnd() {
        if (stages > 0) {
            return false;
        }
        return true;
    }

    private void lowerStage() {
        --this.stages;
    }


    public void decideMove(Car car) {
        if (getRandomNumber() >= 4) {
            car.moveForward();
        }
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : this.carsList) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }
}
