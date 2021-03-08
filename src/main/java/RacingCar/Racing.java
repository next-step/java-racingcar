package RacingCar;

public class Racing {
    MovementCondition movementCondition;
    SimpleRacingResult racingResult;
    int numberOfRacing;
    int numberOfCars;

    public Racing(MovementCondition movementCondition, int numberOfCars, int numberOfRacing) {
        this.movementCondition = movementCondition;
        this.numberOfCars = numberOfCars;
        this.numberOfRacing = numberOfRacing;
        racingResult = new SimpleRacingResult(numberOfCars);
    }

    public RacingResult racing() {
        for (int racingIndex = 0; racingIndex < numberOfRacing; racingIndex++) {
            for (int carIndex = 0; carIndex < numberOfCars; carIndex++) {
                singleRacing(carIndex);
            }
        }

        return racingResult;
    }

    void singleRacing(int carIndex) {
        if (movementCondition.isMovoable()) {
            racingResult.increaseDistance(carIndex);
        }
    }
}
