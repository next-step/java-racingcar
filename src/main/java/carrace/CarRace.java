package carrace;

import java.util.List;

public class CarRace {

    private List<Car> cars;

    public CarRace(List<Car> cars) {
        this.cars = cars;
    }

    public void start() {
        this.cars.stream().forEach(car -> runRound(car));
    }

    private void runRound(Car car) {
        int power = getPower();
        recordRaceResult(car, move(power));
    }

    private void recordRaceResult(Car car, int movement) {
        car.setNewRoundPosition(car.getRecentRoundPosition() + movement);
    }

    private int move(int power) {
        return power < 4 ? 0 : 1;
    }

    private int getPower() {
        return (int) (Math.random() * 10);
    }
}
