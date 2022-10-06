package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarFactory {
    private static final Random random = new Random();

    private RacingCarFactory() {
        throw new RuntimeException("인스턴스화가 불가능한 클래스입니다.");
    }

    public static List<RacingCar> manufactoringCars(int numOfCars, int tryingCount) {
        List<RacingCar> cars = new ArrayList<>(numOfCars);
        for(int i=0 ; i<numOfCars ; i++) {
            cars.add(new RacingCar(random, tryingCount));
        }
        return cars;
    }
}
