package racingcar;

public class Racing {
    private final int maxAttempts;
    private final RacingCars cars;

    public Racing(int maxAttempts, RacingCars cars) {
        this.maxAttempts = maxAttempts;
        this.cars = cars;
    }

    public void start() {
        for (int attempt = 0; attempt < this.maxAttempts; attempt++) {
            cars.turnAroundCircuit();
            Printer.print(cars);
            Printer.println((attempt+1) +"회차 종료");
        }
    }
}
