package RacingCar;

public class Racing {
    private MovementCondition movementCondition;
    private int numberOfRacing;
    private Subject endOfSingleRacingSubject = new RacingSubject();
    private CarCollection carCollection;

    public Racing(MovementCondition movementCondition, CarCollection carCollection, int numberOfRacing) {
        this.movementCondition = movementCondition;
        this.numberOfRacing = numberOfRacing;
        this.carCollection = carCollection;
    }

    public void racing() {
        for (int racingIndex = 0; racingIndex < numberOfRacing; racingIndex++) {
            carCollection.forward(movementCondition);
            endOfSingleRacingSubject.notifyObservers(racingIndex);
        }
    }

    public void addEndOfSingleRacingListener(Observer<Integer> observer) {
        endOfSingleRacingSubject.addObserver(observer);
    }

    public void removeEndOfSingleRacingListener(Observer<Integer> observer) {
        endOfSingleRacingSubject.removeObserver(observer);
    }
}
