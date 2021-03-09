package RacingCar;

public class Racing {
    MovementCondition movementCondition;
    SimpleRacingResult racingResult;
    int numberOfRacing;
    int numberOfCars;
    Subject endOfSingleRacingSubject = new RacingSubject();

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
        if (movementCondition.isMovoable()) {
            racingResult.increaseDistance(carIndex);
        }
    }

    public void addEndOfSingleRacingListener(Observer<RacingResult> observer) {
        endOfSingleRacingSubject.addObserver(observer);
    }

    public void removeEndOfSingleRacingListener(Observer<RacingResult> observer) {
        endOfSingleRacingSubject.removeObserver(observer);
    }
}
