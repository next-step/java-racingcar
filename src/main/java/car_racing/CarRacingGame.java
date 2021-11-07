package car_racing;

public class CarRacingGame {

    private final RacingResult racingResult;
    private final Cars cars;
    private final int numberOfRound;

    public CarRacingGame(int numberOfCar, int numberOfRound) {
        racingResult = new RacingResult();
        this.cars = new Cars(numberOfCar);
        this.numberOfRound = numberOfRound;
    }

    public String play() {
        for(int i = 0; i < numberOfRound; i++) {
            racingOneRound();
            updateRacingResult();
        }

        return getRacingResult();
    }

    private void racingOneRound() {
        cars.playOneRound();
    }

    private void updateRacingResult() {
        racingResult.update(cars);
    }

    private String getRacingResult() {
        return racingResult.getResult();
    }

}
