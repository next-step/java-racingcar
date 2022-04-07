package step03;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = Collections.unmodifiableList(carList);
    }

    public List<Integer> move(List<Integer> moveCounts) {
        int carSize = carList.size();
        int index = 0;

        while (index < carSize) {
            Car car = carList.get(index);
            car.move(moveCounts.get(index));
            index++;
        }

        return getCarCurrentLocations();
    }

    private List<Integer> getCarCurrentLocations() {
        return carList.stream()
                .map(Car::getCurrentLocation)
                .collect(Collectors.toList());
    }

}
