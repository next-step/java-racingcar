package racing;

public final class RacingCars {

    private final Car[] cars;

    public RacingCars(final int carCount) {
        this.cars = new Car[carCount];
    }

    public Car[] getCars() {
        return cars;
    }

    public void ready() {
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }
    }

    public void race(Roulette roulette) {
        for (final Car car : this.cars) {
            boolean canMove = (roulette.spin() >= 4);
            car.move(canMove);
        }
    }
}
