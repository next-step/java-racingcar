package car_racing;

public class CarRacingGame {

    private final CarRacingResult carRacingResult;
    private final Cars cars;
    private final int numberOfRound;

    public CarRacingGame(int numberOfCar, int numberOfRound) {
        carRacingResult = new CarRacingResult();
        this.cars = new Cars(numberOfCar);
        this.numberOfRound = numberOfRound;
    }

    public CarRacingResult play() {
        for (int i = 0; i < numberOfRound; i++) {
            racingOneRound();
            updateRacingResult();
        }

        return getRacingResult();
    }

    private void racingOneRound() {
        cars.playOneRound();
    }

    private void updateRacingResult() {
        carRacingResult.update(cars);
    }

    private CarRacingResult getRacingResult() {
        return carRacingResult;
    }

}
