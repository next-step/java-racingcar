package step2.domain;

import step2.utils.NumberGenerator;

public class CarRace {

    private Cars cars;
    private NumberGenerator numberGenerator;

    private CarRace(Cars cars) {
        this.cars = cars;
    }

    public CarRace raceStart(int numberOfCars) {
        return new CarRace(Cars.makeCars(numberOfCars));
    }

    public Cars executeTrials() {
        int randomNumber = this.numberGenerator.getRandomNumber();
        return cars.moveCars(randomNumber);
    }

}
