package study.racingcar.domain;

import study.racingcar.utils.NumberUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameCars implements Iterable<Car> {
    /**
     * Car의 list의 일급 컬렉션
     */
    private final List<Car> cars;

    public GameCars(int carNum) {
        validateTotalCarNum(carNum);
        this.cars = new ArrayList<>();
        generateCars(carNum);
    }

    private void validateTotalCarNum(int carNum) {
        if (NumberUtils.isNotPositive(carNum)) {
            throw new IllegalArgumentException("1보다 큰 수를 입력하세요");
        }
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
