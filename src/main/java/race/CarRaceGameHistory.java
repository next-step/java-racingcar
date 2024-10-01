package race;

public class CarRaceGameHistory {
    private int round;
    private Car car;
    private int step;

    private CarRaceGameHistory(int round, Car car, int step) {
        this.round = round;
        this.car = car;
        this.step = step;
    }

    public Car getCar() {
        return this.car;
    }

    public int getStep() {
        return this.step;
    }

    public int getRound() {
        return this.round;
    }

    private static CarRaceGameHistory create(int round, Car car, int step) {
        return new CarRaceGameHistory(round, car, step);
    }

    public static CarRaceGameHistory[] record(int round, Car[] cars) {
        CarRaceGameHistory[] histories = new CarRaceGameHistory[cars.length];

        for (int i = 0; i < cars.length; i++) {
            histories[i] = CarRaceGameHistory.create(round, cars[i], cars[i].getCurrentStep());
        }

        return histories;
    }
}
