package domain;

import java.util.ArrayList;
import java.util.Random;

public class Racing {
    private static final int THRESHOLD = 4;
    private static final int RANDOM_BOUND = 10;
    private static final int STAGE_END_BOUND = 0;

    private ArrayList<Car> carsList;
    private int stages;

    public Racing(ArrayList<Car> carsList, int stages) {
        this.carsList = carsList;
        this.stages = stages;
    }

    public void moveCars() {
        for (Car car : carsList) {
            decideMove(car);
        }
        this.lowerStage();
    }

    public ArrayList<Car> getCarsList() {
        return this.carsList;
    }

    public boolean isEnd() {
        if (stages > STAGE_END_BOUND) {
            return false;
        }
        return true;
    }

    private void lowerStage() {
        --this.stages;
    }


    public void decideMove(Car car) {
        if (getRandomNumber() >= THRESHOLD) {
            car.moveForward();
        }
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }

    public int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : this.carsList) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }
}
