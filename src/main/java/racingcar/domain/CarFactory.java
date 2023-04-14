package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차 생성 공장 (CarFactory) - 책임 - 지정된 수의 Car 객체를 생성한다.
 */
public class CarFactory {

    public static List<RacingCar> makeCars(int numberOfCars) {
        List<RacingCar> racingCars = new ArrayList<>();

        for(int i=0; i<numberOfCars; i++) {
            racingCars.add(new RacingCar());
        }

        return racingCars;
    }
}
