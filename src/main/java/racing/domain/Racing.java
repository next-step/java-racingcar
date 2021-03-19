package racing.domain;

public class Racing {
    public static final int MIN_ATTEMPT_COUNT = 0;

    private final Cars cars;
    private int attemptsCount;

    public Racing(String[] carNames, int attemptsCount) {
        this(new Cars(carNames), attemptsCount);
    }

    public Racing(Cars cars, int attemptsCount) {
        this.cars = cars;
        this.attemptsCount = attemptsCount;
    }

    public void runRace() {
        cars.tryMoveAll();
        attemptsCount--;
    }

    public boolean racing() {
        return attemptsCount > MIN_ATTEMPT_COUNT;
    }

    public Round currentRound() {
        return new Round(cars);
    }
}