package racing.model;

import java.util.*;

public class RacingCars {
    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(int racingCarCount) {
        prepare(racingCarCount);
    }

    private void prepare(int racingCarCount) {
        for (int i = 0; i < racingCarCount; i++) {
            addRacingCar();
        }
    }

    private void addRacingCar() {
        racingCars.add(new RacingCar());
    }

    public int getSize() {
        return racingCars.size();
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

    public int[] getRacingCarPositions() {
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .toArray();
    }
}
