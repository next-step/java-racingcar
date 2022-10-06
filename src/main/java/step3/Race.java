package step3;

public class Race {

    private int currentRound = 1;

    private final int totalRound;

    private final Cars cars;

    public Race(int totalRound, int numberOfCar, MovableStrategy movableStrategy) {
        this.totalRound = totalRound;
        this.cars = new Cars(numberOfCar, movableStrategy);
    }

    public Cars cars() {
        return this.cars;
    }

    public boolean isInRace() {
        return this.currentRound <= this.totalRound;
    }

    public void nextRound() {
        this.currentRound++;
    }

    public void proceed() {
        for (Car car : this.cars) {
            car.moveOrStop();
        }
    }
}
