package racing.domain;

import racing.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;

    public Cars(List<String> nameList) {
        this.carList = makeCarList(nameList);
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    public List<Car> makeCarList(List<String> nameList) {
        List<Car> carList = new ArrayList<Car>();
        for (String name : nameList) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public void playRacing(MoveStrategy moveStrategy) {
        for (Car car : carList) {
            car.movable(moveStrategy);
        }
    }

    private Integer findMaxPosition() {
        return carList.stream()
                .mapToInt(car -> car.getPosition()
                .getPosition())
                .max()
                .orElse(0);
    }

    public List<Car> findWinnerList() {
        return carList.stream()
                .filter(car -> car.getPosition().getPosition() >= findMaxPosition())
                .collect(Collectors.toList());
    }
}
