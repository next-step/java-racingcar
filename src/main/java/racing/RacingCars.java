package racing;

public final class RacingCars {

    private final Car[] cars;

    public RacingCars(final int carCount) {
        this.cars = new Car[carCount];
    }

    public void ready() {
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }
    }

    public void race() {
        for (final Car car : this.cars) {
            if (Roulette.spin() >= 4) {
                car.move();
            }
        }
    }

    public Car[] getCars() {
        return cars;
    }
}
