package racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(final String[] names) {
        List<Car> cars = generate(names);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCarsSize() {
        return cars.size();
    }

    public int getRoundDistance(final int index, final int roundNumber) {
        return cars.get(index).getRoundDistance(roundNumber);
    }

    public String getName(final int index) {
        return cars.get(index).getName();
    }

    public List<Car> generate(final String[] names) {
        return Arrays.stream(names)
            .map(name -> new Car(name))
            .collect(Collectors.toList());
    }

    public void round() {
        for (Car car : cars) {
            int moveNum = Random.getMoveRandomNumber();
            car.move(moveNum);
        }
    }

}
