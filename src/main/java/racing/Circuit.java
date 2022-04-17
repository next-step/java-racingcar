package racing;


import java.util.ArrayList;
import java.util.List;

public class Circuit {

    private final List<Car> cars;

    public Circuit(int carCount, int racingCount) {
        Engine engine = new Engine();
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(engine, racingCount));
        }
    }

    public void startRacing() {
        for (Car car : cars) {
            car.racingStart();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
