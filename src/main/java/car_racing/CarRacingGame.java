package car_racing;

public class CarRacingGame {

    private static final String ONE_ROUND_ENDS = "\n";
    private final StringBuilder racingResult;
    private final Car[] cars;
    private final int numberOfRound;

    public CarRacingGame(int numberOfCar, int numberOfRound) {
        racingResult = new StringBuilder();
        this.cars = createCars(numberOfCar);
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
        for(int i = 0; i < cars.length; i++) {
            cars[i].move();
        }
    }

    private void updateRacingResult() {
        for(int i = 0; i < cars.length; i++) {
            racingResult.append(cars[i].getCurrStatus());
            racingResult.append(ONE_ROUND_ENDS);
        }
        racingResult.append(ONE_ROUND_ENDS);
    }

    private String getRacingResult() {
        return racingResult.toString();
    }

    private Car[] createCars(int numberOfCar) {
        Car[] cars = new Car[numberOfCar];

        for(int i = 0; i < numberOfCar; i++) {
            cars[i] = new Car();
        }

        return cars;
    }
}
