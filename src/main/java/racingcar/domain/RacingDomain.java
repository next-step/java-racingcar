package racingcar.domain;

import racingcar.domain.CarDomain;

import java.util.ArrayList;
import java.util.Random;

public class RacingDomain {
    private static final int THRESHOLD = 4;
    private static final int RANDOM_BOUND = 10;
    private static final int STAGE_END_BOUND = 0;

    private ArrayList<CarDomain> carsList;
    private int stages;

    public RacingDomain(ArrayList<CarDomain> carsList, int stages) {
        this.carsList = carsList;
        this.stages = stages;
    }

    public void moveCars() {
        for (CarDomain carDomain : carsList) {
            decideMove(carDomain);
        }
        this.lowerStage();
    }

    public ArrayList<CarDomain> getCarsList() {
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


    public void decideMove(CarDomain carDomain) {
        if (getRandomNumber() >= THRESHOLD) {
            carDomain.moveForward();
        }
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }

    public int getMaxDistance() {
        int maxDistance = 0;
        for (CarDomain carDomain : this.carsList) {
            maxDistance = Math.max(maxDistance, carDomain.getDistance());
        }
        return maxDistance;
    }
}
