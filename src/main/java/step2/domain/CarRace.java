package step2.domain;

import step2.utils.NumberGenerator;

public class CarRace {

    private Cars cars;

    private CarRace(Cars cars) {
        this.cars = cars;
    }

    public CarRace raceStart(int numberOfCars) {
        return new CarRace(Cars.makeCars(numberOfCars));
    }

    public Cars executeTrials(NumberGenerator numberGenerator) {
        int randomNumber = numberGenerator.getRandomNumber();
        return cars.moveCars(randomNumber);
    }

}
