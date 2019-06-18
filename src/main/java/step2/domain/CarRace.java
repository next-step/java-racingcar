package step2.domain;

import step2.utils.NumberGenerator;

public class CarRace {

    private Cars cars;
    private int numberOfTrials;

    private CarRace(Cars cars, int numberOfTrials) {
        this.cars = cars;
        this.numberOfTrials = numberOfTrials;
    }

    public CarRace raceStart(int numberOfCars, int numberOfTrials) {
        return new CarRace(Cars.makeCars(numberOfCars), numberOfTrials);
    }

    public Cars executeTrials(NumberGenerator numberGenerator) {
        int randomNumber = numberGenerator.getRandomNumber();
        return cars.moveCars(randomNumber);
    }

}
