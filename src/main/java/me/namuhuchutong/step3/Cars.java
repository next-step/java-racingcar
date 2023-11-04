package me.namuhuchutong.step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> carList;

    public static Cars createCars(int numberOfCars) {
        validateNumberOfCars(numberOfCars);
        List<Car> collect = IntStream.range(0, numberOfCars)
                                     .mapToObj(i -> new Car())
                                     .collect(Collectors.toList());
        return new Cars(collect);
    }

    private static void validateNumberOfCars(int numberOfCars) {
        if (numberOfCars <= 0) {
            throw new IllegalArgumentException("자동차 수는 음수이거나 0일 수 없습니다. - " + numberOfCars);
        }
    }

    private  Cars(List<Car> carList) {
        this.carList = carList;
    }
}
