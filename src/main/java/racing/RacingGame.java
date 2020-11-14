package racing;

public class RacingGame {

    private final Cars cars;

    public RacingGame(int participationCars) {
        cars = new Cars(participationCars);
    }

    public void go() {
        cars.go();
    }

    public Car getCar(int testCarNumber) {
        return cars.getCar(testCarNumber);
    }

    public int getCarsSize() {
        return cars.size();
    }
}
