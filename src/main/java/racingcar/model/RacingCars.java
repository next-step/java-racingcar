package racingcar.model;

import java.util.*;

public class RacingCars {
    private static final String INPUT_COUNT_ERROR_MESSAGE = "구분자는 ,를 사용해서 이름을 1개 이상 입력해주세요";

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getValue() {
        return Collections.unmodifiableList(racingCars);
    }

    public static RacingCars create(String names) {
        List<RacingCar> racingCars = new ArrayList<>();
        String[] namesArray = validate(names);
        for (int i = 0; i < namesArray.length; i++) {
            racingCars.add(new RacingCar(namesArray[i]));
        }

        return new RacingCars(racingCars);
    }

    public void move(MovableStrategy movableStrategy) {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(movableStrategy);
        }
    }

    private static int validate(int value) {
        if (value <= 0) {
            throw new IllegalStateException(INPUT_COUNT_ERROR_MESSAGE);
        }
        return value;
    }
}
