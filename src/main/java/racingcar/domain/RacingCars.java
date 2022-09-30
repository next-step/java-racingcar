package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<RacingCar> value;

    public RacingCars(List<RacingCar> value) {
        validateEmpty(value);
        this.value = value;
    }

    public static RacingCars from(String[] names) {
        validateNames(names);
        List<RacingCar> cars = Arrays.stream(names)
            .map(RacingCar::new)
            .collect(Collectors.toList());
        return new RacingCars(cars);
    }

    public void move(List<MoveCondition> conditions) {
        validateConditionsCount(conditions);
        for (int i = 0; i < value.size(); i++) {
            RacingCar racingCar = value.get(i);
            racingCar.move(conditions.get(i));
        }
    }

    public int size() {
        return value.size();
    }

    public List<RacingCar> getValue() {
        return value;
    }

    public List<String> getAllNames() {
        return value.stream()
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }

    private void validateConditionsCount(List<MoveCondition> conditions) {
        if (conditions.size() != value.size()) {
            throw new IllegalArgumentException("racingCars와 conditions의 개수는 같아야합니다. | racingCars 개수: " + value.size() + " | conditions 개수: " + conditions.size());
        }
    }

    private static void validateNames(String[] names) {
        validateEmpty(names);
        validateDuplicateName(names);
    }

    private void validateEmpty(List<RacingCar> racingCars) {
        if (racingCars == null || racingCars.isEmpty()) {
            throw new IllegalArgumentException("racingCars 값은 비어있을 수 없습니다. | 입력된 names: " + racingCars);
        }
    }

    private static void validateEmpty(String[] names) {
        if (names == null || names.length == 0) {
            throw new IllegalArgumentException("names 값은 비어있을 수 없습니다. | 입력된 names: " + Arrays.toString(names));
        }
    }

    private static void validateDuplicateName(String[] names) {
        if (Arrays.stream(names).distinct().count() != names.length) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재할 수 없습니다. | 입력된 names: " + Arrays.toString(names));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RacingCars)) {
            return false;
        }

        RacingCars that = (RacingCars) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
