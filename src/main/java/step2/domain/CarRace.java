package step2.domain;

import step2.utils.NumberGenerator;

public class CarRace {

    private final static int MINIMUM_NUMBER_CAN_BE_INPUT = 1;
    private Cars cars;
    private NumberGenerator numberGenerator;

    private CarRace(Cars cars) {
        this.cars = cars;
    }

    public CarRace raceStart(int numberOfCars, int numberOfTrials) {
        numberOfCarsValidation(numberOfCars);
        numberOfTrialsValidation(numberOfTrials);
        return new CarRace(Cars.makeCars(numberOfCars));
    }

    public Cars executeTrials() {
        int randomNumber = this.numberGenerator.getRandomNumber();
        return cars.moveCars(randomNumber);
    }

    private void numberOfCarsValidation(int numberOfCars) {
        if (numberOfCars < MINIMUM_NUMBER_CAN_BE_INPUT) {
            throw new IllegalArgumentException("최소 1대의 자동차가 필요합니다.");
        }
    }

    private void numberOfTrialsValidation(int numberOfTrials) {
        if (numberOfTrials < MINIMUM_NUMBER_CAN_BE_INPUT) {
            throw new IllegalArgumentException("최소 1번의 시행 횟수가 필요합니다.");
        }
    }

}
