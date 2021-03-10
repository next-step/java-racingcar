package RacingCar;

import java.util.List;

public class Racing {
    private MovementCondition movementCondition;
    private int numberOfRacing;
    private Subject endOfSingleRacingSubject = new RacingSubject();
    private List<Car> cars;

    public Racing(MovementCondition movementCondition, List<Car> cars, int numberOfRacing) {
        this.movementCondition = movementCondition;
        this.numberOfRacing = numberOfRacing;
        this.cars = cars;
    }

    public void racing() {
        race();
    }

    public void addEndOfSingleRacingListener(Observer<Integer> observer) {
        endOfSingleRacingSubject.addObserver(observer);
    }

    public void removeEndOfSingleRacingListener(Observer<Integer> observer) {
        endOfSingleRacingSubject.removeObserver(observer);
    }

    private void race() {
        for (int racingIndex = 0; racingIndex < numberOfRacing; racingIndex++) {
            raceSingleRacing();
            endOfSingleRacingSubject.notifyObservers(racingIndex);
        }
    }

    private void raceSingleRacing() {
        cars.forEach(car -> raceSingleCar(car));
    }

    private void raceSingleCar(Car car) {
        if (movementCondition.isMovable()) {
            car.forward();
        }
    }
}
