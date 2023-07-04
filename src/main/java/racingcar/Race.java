package racingcar;

public class Race {

    private final Car[] cars;
    private int leftRound;

    private Race(Car[] cars, int leftRound) {
        this.cars = cars;
        this.leftRound = leftRound;
    }

    public static Race of(Car[] cars, int count) {
        return new Race(cars, count);
    }

    public int getLeftRound() {
        return this.leftRound;
    }

    public void play(NumberGenerator numberGenerator) {
        startRound();
        for (Car car : cars) {
            if (RaceUtil.determineCarMovement(numberGenerator.generate())) {
                car.moveForward();
            }
        }
    }

    private void startRound() {
        this.leftRound--;
    }
}
