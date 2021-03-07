package step3.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차의 생성을 관리할 클래스
 */
public final class CarGenerator {

    private CarGenerator() { }

    public static List<Car> of(int carSize) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0 ; i < carSize ; i++) {
            cars.add(Car.of());
        }
        return cars;
    }
}
