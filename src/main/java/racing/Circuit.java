package racing;


import java.util.ArrayList;
import java.util.List;

public class Circuit {

    private final List<Car> cars;
    private final Integer numberOfRacing;

    public Circuit(int numberOfCars, int numberOfMoves) {
        this.numberOfRacing = numberOfMoves;
        Engine engine = new Engine();
        cars = createCars(engine, numberOfCars, numberOfMoves);
    }

    private List<Car> createCars(Engine engine, int numberOfCar, int numberOfMoves) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car(engine, numberOfMoves));
        }
        return cars;
    }

    public void startRacing() {
        for (Car car : cars) {
            car.racingStart();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Integer getNumberOfRacing() {
        return this.numberOfRacing;
    }
}
