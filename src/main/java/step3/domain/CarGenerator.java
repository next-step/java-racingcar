package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static step3.util.Constants.START_IDX;

/**
 * 자동차의 생성을 관리할 클래스
 */
public final class CarGenerator {

    private CarGenerator() { }

    public static List<Car> of(int carSize) {
        List<Car> cars = new ArrayList<>();
        IntStream.range(START_IDX, carSize)
                .forEach(value -> cars.add(Car.of()));
        return cars;
    }
}
