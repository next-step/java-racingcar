package RacingCar;

public class Racing {
    public Racing(MovementCondition movementCondition, int numberOfCars, int numberOfRacing) {
        this.movementCondition = movementCondition;
        this.numberOfCars = numberOfCars;
        this.numberOfRacing = numberOfRacing;
        racingResult = new SimpleRacingResult(numberOfCars);
    }

    public RacingResult racing() {
        race();
        return racingResult;
    }

    public void addEndOfSingleRacingListener(Observer<RacingResult> observer) {
        endOfSingleRacingSubject.addObserver(observer);
    }

    public void removeEndOfSingleRacingListener(Observer<RacingResult> observer) {
        endOfSingleRacingSubject.removeObserver(observer);
    }

    private void race() {
        for (int racingIndex = 0; racingIndex < numberOfRacing; racingIndex++) {
            raceSingleRacing();
        }
    }

    private void raceSingleRacing() {
        for (int carIndex = 0; carIndex < numberOfCars; carIndex++) {
            raceSingleCar(carIndex);
        }
        endOfSingleRacingSubject.notifyObservers(racingResult);
    }

    private void raceSingleCar(int carIndex) {
        if (movementCondition.isMovable()) {
            racingResult.increaseDistance(carIndex);
        }
    }

    private MovementCondition movementCondition;
    private SimpleRacingResult racingResult;
    private int numberOfRacing;
    private int numberOfCars;
    private Subject endOfSingleRacingSubject = new RacingSubject();
}
