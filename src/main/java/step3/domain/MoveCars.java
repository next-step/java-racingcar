package step3.domain;

public class MoveCars {
    private final int turnCount;
    private final int decisionValue;
    private final Cars cars;
    private String racingLog = "";

    public MoveCars(int turnCount, int decisionValue, Cars cars) {
        this.turnCount = turnCount;
        this.decisionValue = decisionValue;
        this.cars = cars;
    }

    public void race() {
        for (int i = 0; i < turnCount; i++) {
            moveCar();
            racingLog(cars);
        }
    }

    private void moveCar() {
        for (Car car : cars.getCars()) {
            car.move(RandomInt.value(), decisionValue);
        }

    }

    private void racingLog(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars.getCars()) {
            stringBuilder.append(car.name()).append(" : ");
            stringBuilder.append("-".repeat(Math.max(0, car.position())));
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");
        racingLog += stringBuilder.toString();
    }

    public String getRacingLog() {
        return racingLog;
    }
}
