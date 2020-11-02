package step3.domain;

public class Simulator {
    private final Cars cars;
    private final Integer tryCount;

    public Simulator(Integer tryCount, Cars cars) {
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public void execute() {
        for (int i = 0; i < tryCount; i++) {
            cars.move();
        }
    }

}
