package study.racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameCars implements Iterable<Car> {
    /**
     * Car의 list의 일급 컬렉션
     */
    private final List<Car> cars;

    public GameCars(int carNum) {
        this.cars = new ArrayList<>();
        generateCars(carNum);

    }

    private void generateCars(int carNum) {
        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
