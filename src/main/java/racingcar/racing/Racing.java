package racingcar.racing;

public class Racing {
    private final Cars cars;
    private final int numberOfRounds;
    private final StringBuilder result = new StringBuilder();

    public Racing(Cars cars, int numberOfRounds) {
        this.cars = cars;
        this.numberOfRounds = numberOfRounds;
    }

    public void start() {
        for (int i = 0; i < numberOfRounds; i++) {
            cars.moveAll();
            result.append(cars).append("\n");
        }
    }

    @Override
    public String toString() {
        cars.getCarsWithMaxDistance()
                .stream()
                .map(Car::getName)
                .reduce((a, b) -> a + ", " + b)
                .ifPresent(result::append);
        result.append("가 최종 우승했습니다.");
        return result.toString();
    }
}