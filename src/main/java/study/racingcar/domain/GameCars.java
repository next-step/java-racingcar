package study.racingcar.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameCars implements Iterable<Car> {
    /**
     * Car의 list의 일급 컬렉션
     */
    private final List<Car> cars;

    public GameCars(List<String> carNames) {
        this.cars = new ArrayList<>();
        generateCars(carNames);
    }

    private void generateCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
