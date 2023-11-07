package racing.util;

import racing.Car;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {

    /**
     * 전부 기본값으로 값이 세팅된 자동차를 지정된 개수만큼 반환합니다.
     *
     * @param theNumberOfCars 생성할 자동차 개수
     *
     * @return 생성된 자동차 목록
     */
    public static List<Car> createMultipleDefaultCars(int theNumberOfCars) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < theNumberOfCars; i++) {
            carList.add(new Car());
        }
        return carList;
    }
}
