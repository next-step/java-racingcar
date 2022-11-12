package race.domian;

import java.util.ArrayList;
import java.util.List;
import race.strategy.MoveStrategy;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void move(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public int[] getPosition() {
        int[] positions = new int[cars.size()];
        int carNumber = 0;
        for (Car car : cars) {
            positions[carNumber] = car.getPosition();
            carNumber++;
        }
        return positions;
    }

    public String[] getNames() {
        String[] names = new String[cars.size()];
        int carNumber = 0;
        for (Car car : cars) {
            names[carNumber] = car.getName();
            carNumber++;
        }
        return names;
    }
}
