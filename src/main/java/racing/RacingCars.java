package racing;

public final class RacingCars {

    private Car[] cars;

    private final int carCount;

    public RacingCars(final int carCount) {
        this.carCount = carCount;
    }

    public void enterCars() {
        cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
    }

    public Car[] getCars() {
        return cars;
    }
}
