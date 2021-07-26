package racing.model;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RacingCars {
    private static final int MIN_RACING_CAR_COUNT = 1;

    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(int racingCarCount) {
        validateMinCount(racingCarCount);
        prepare(racingCarCount);
    }

    private void validateMinCount(int racingCarCount) {
        if (racingCarCount < MIN_RACING_CAR_COUNT) {
            throw new IllegalArgumentException(String.format("자동차는 %d대 이상이어야 합니다.", MIN_RACING_CAR_COUNT));
        }
    }

    private void prepare(int racingCarCount) {
        racingCars = Stream.generate(RacingCar::new)
                .limit(racingCarCount)
                .collect(toList());
    }

    public int getSize() {
        return racingCars.size();
    }

    public void moveOrStop(List<Number> numbers) {
        validateEqualSize(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            RacingCar racingCar = racingCars.get(i);
            racingCar.moveOrStop(numbers.get(i));
        }
    }

    private void validateEqualSize(List<Number> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("숫자 목록이 비어있습니다.");
        }

        if (racingCars.size() != numbers.size()) {
            throw new IllegalArgumentException("숫자의 개수가 자동차 대수와 같지 않습니다.");
        }
    }

    public int[] getRacingCarPositions() {
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .toArray();
    }
}
