package camp.nextstep.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> of(int countOfCar) {
        validateCount(countOfCar);
        return generateByCount(countOfCar);
    }

    private static void validateCount(int countOfCar) {
        if (countOfCar <= 0) {
            throw new IllegalArgumentException("차량 갯수가 없거나 올바르지 않습니다.");
        }
    }

    private static List<Car> generateByCount(int countOfCar) {
        List<Car> racingCars = new ArrayList<>(countOfCar);
        for (int i = 0; i < countOfCar; i++) {
            racingCars.add(new Car());
        }
        return racingCars;
    }

}
