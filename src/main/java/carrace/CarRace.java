package carrace;

public class CarRace {

    private final Cars cars;
    private final int numberOfLaps;

    public CarRace(Cars cars, int numberOfLaps) {
        this.cars = cars;
        this.numberOfLaps = numberOfLaps;
    }

    public void start() {
        ResultView.prePrint();
        for (int i = 0; i < numberOfLaps; i++) {
            cars.move();
            ResultView.print(cars);
        }
    }
}
