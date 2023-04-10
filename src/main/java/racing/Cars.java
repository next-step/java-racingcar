package racing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;
    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public List<Integer> valueOfCarsPosition() {
        List<Integer> currentPositions = new ArrayList<>();
        for (Car car : carList) {
            currentPositions.add(car.valueOfCurrentPosition());
        }
        return currentPositions;
//        return carList.stream().map(Car::valueOfCurrentPosition)
//                .collect(Collectors.toList());
    }
}
