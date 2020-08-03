package step03;

import java.util.HashMap;
import java.util.Map;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment : Car의 책임 : 차의 초기화를 담당 (첫 번쨰 위치 0 설)
 * Time : 9:23 오후
 */
public class Car {

    private Map<Car, Integer> map = new HashMap<>();

    public Map<Car, Integer> initCar(final int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            final Car car = new Car();
            map.put(car, 0);
        }

        return map;
    }

}
