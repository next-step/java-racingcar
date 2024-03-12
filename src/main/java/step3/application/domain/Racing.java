package step3.application.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final RacingCars racingCars;

    public Racing(int carCount) {
        validateCount(carCount);
        this.racingCars = new RacingCars(createRacingGroup(carCount));
    }

    private List<Car> createRacingGroup(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(i));
        }
        return cars;
    }

    public void startRace(int moveCount) {
        validateCount(moveCount);
        doRace(moveCount);
    }

    private void doRace(int count) {
        for (int i = 0; i < count; i++) {
            racingCars.moveCars();
            System.out.println();
        }
    }

    private static void validateCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
    }
}
