package racing;

import java.util.ArrayList;
import java.util.List;

public class Racers {
    private List<Car> cars = new ArrayList<>();

    public Racers(int size) {
        for (int i = 0; i < size; i++) {
            cars.add(new Car());
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move(CountGenerator.getRandomInt());
        }
    }

    public int size() {
        return cars.size();
    }

    public int getPosition(int index) {
        return cars.get(index).position();
    }
}
