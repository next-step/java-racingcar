package step3.domain;


import step3.utils.NumberGenerator;

public class Round {

    private Cars cars;
    private NumberGenerator numberGenerator;

    public Round(final Cars cars, final NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public void playRound(final Cars cars) {
        this.cars = cars;
        cars.moveForwardCars(numberGenerator);
    }

    public Cars getRoundCarStatus() {
        return cars;
    }

}
