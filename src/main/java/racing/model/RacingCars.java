package racing.model;

import java.util.*;

public class RacingCars {
    private static final int MIN_RACING_CAR_COUNT = 1;

    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(int racingCarCount) {
        validateMinCount(racingCarCount);
        prepare(racingCarCount);
    }

    private void validateMinCount(int racingCarCount) {
        if (racingCarCount < MIN_RACING_CAR_COUNT) {
            throw new IllegalArgumentException(String.format("자동차는 %d 대 이상이어야 합니다.", MIN_RACING_CAR_COUNT));
        }
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

    public void moveOrStop(List<Integer> numbers) {
        validateEqualSize(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            RacingCar racingCar = racingCars.get(i);
            racingCar.moveOrStop(numbers.get(i));
        }
    }

    private void validateEqualSize(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("숫자 목록이 비어있습니다.");
        }

        if (racingCars.size() != numbers.size()) {
            throw new IllegalArgumentException("숫자의 개수가 자동차 개수와 같지 않습니다.");
        }
    }

    public int[] getRacingCarPositions() {
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .toArray();
    }
}
