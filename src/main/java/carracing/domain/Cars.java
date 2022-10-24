package carracing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars{

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        // return Collections.unmodifiableList(cars);
        return new ArrayList<>(cars);
    }

    public boolean isEmpty() {
        return cars.isEmpty();
    }

    public static Cars makeCars(String[] Names) {
        List<Car> carList = makeCarList(Names);
        Cars cars = new Cars(carList);
        return cars;
    }

    public void moveCars(MovingStrategy movingStrategy) {
        cars.forEach(car -> car.move(movingStrategy));
    }

    private static List<Car> makeCarList(String[] names) {
        List<Car> carList = new ArrayList<>();
        Arrays.stream(names)
                .map(name -> new Car(name))
                .collect(Collectors.toList());

        return carList;
    }


}
