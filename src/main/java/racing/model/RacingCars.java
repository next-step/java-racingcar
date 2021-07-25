package racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingCars {
    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(int count) {
        prepare(count);
    }

    private void prepare(int count) {
        for (int i = 0; i < count; i++) {
            addRacingCar();
        }
    }

    private void addRacingCar() {
        racingCars.add(new RacingCar());
    }

    public void moveOrStop(Map<Integer, Integer> racingCarIndexAndNumber) {
        for (Integer index : racingCarIndexAndNumber.keySet()) {
            validateNotNull(index);
            validateRange(index);

            RacingCar racingCar = racingCars.get(index);
            int number = racingCarIndexAndNumber.get(index);
            racingCar.moveOrStop(number);
        }
    }

    private void validateNotNull(Integer index) {
        if (index == null) {
            throw new IllegalArgumentException("index 값이 null이 될 수 없습니다.");
        }
    }

    private void validateRange(Integer index) {
        if (index < 0 || index >= racingCars.size()) {
            throw new IllegalArgumentException(String.format("값이 유효한 범위 안에 있지 않습니다. (index: %d)", index));
        }
    }
}
