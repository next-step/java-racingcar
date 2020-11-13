package racing;

public class RacingGame {

    private final Cars cars;

    public RacingGame(int participationCars) {
        cars = new Cars(participationCars);
    }

    public void go() {
        for (int i = 0; i < cars.size(); i++) {
            cars.getCar(i).move(new MoveStrategyImpl());
        }
    }

    public Car getCar(int testCarNumber) {
        return cars.getCar(testCarNumber);
    }

    public int getCarsSize() {
        return cars.size();
    }
}
