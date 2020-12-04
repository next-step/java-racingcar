package racingCar.domain;

import racingCar.RacingCarUtils;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> cars;

    public Racing(int carNums) {
        this.cars = mapCars(carNums);
    }

    private static List<Car> mapCars(int carNums) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNums; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void race() {
        for (Car car : cars) {
            car.racing(RacingCarUtils.RandomValueGenerator());
        }
    }







    //생성된 자동차한테 racing 처리하기
    // output view한테 그림그리게 시키기
}
