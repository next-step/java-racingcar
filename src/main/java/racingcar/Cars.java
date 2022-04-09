package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = Collections.unmodifiableList(carList);
    }

    public List<CarLocationResult> move(List<Integer> moveCounts) {
        for (int index = 0; index < carList.size(); index++) {
            Car car = carList.get(index);
            car.move(moveCounts.get(index));
        }

        return getCarLocationResult();
    }

    private List<CarLocationResult> getCarLocationResult() {
        return carList.stream()
                .map(CarLocationResult::new)
                .collect(Collectors.toList());
    }

}
