package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import racingcar.dto.RacingCarPrintDTO;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        validateEmpty(racingCars);
        this.racingCars = racingCars;
    }

    public RacingCars(String[] names) {
        validateEmpty(names);
        validateDuplicateName(names);
        this.racingCars = Arrays.stream(names)
            .map(RacingCar::new)
            .collect(Collectors.toList());
    }

    public void move(List<MoveCondition> conditions) {
        validateConditionsCount(conditions);
        for (int i = 0; i < racingCars.size(); i++) {
            RacingCar racingCar = racingCars.get(i);
            racingCar.move(conditions.get(i));
        }
    }

    public int size() {
        return racingCars.size();
    }

    private void validateConditionsCount(List<MoveCondition> conditions) {
        if (conditions.size() != racingCars.size()) {
            throw new RuntimeException("racingCars와 conditions의 개수는 같아야합니다..");
        }
    }

    private void validateEmpty(List<RacingCar> racingCars) {
        if (racingCars == null || racingCars.isEmpty()) {
            throw new RuntimeException("racingCars 값은 비어있을 수 없습니다.");
        }
    }

    private void validateEmpty(String[] names) {
        if (names == null || names.length == 0) {
            throw new RuntimeException("names 값은 비어있을 수 없습니다.");
        }
    }

    private void validateDuplicateName(String[] names) {
        if (Arrays.stream(names).distinct().count() != names.length) {
            throw new RuntimeException("중복된 자동차 이름이 존재할 수 없습니다.");
        }
    }

    public List<RacingCar> getWinners() {
        int maxPosition = getMaxPosition();
        return racingCars.stream()
            .filter(racingCar -> racingCar.isEqualsPosition(maxPosition))
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (RacingCar racingCar : racingCars) {
            int position = racingCar.getPosition();
            maxPosition = Math.max(maxPosition, position);
        }

        return maxPosition;
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
        return Objects.equals(racingCars, that.racingCars);
    }

    @Override
    public int hashCode() {
        return racingCars != null ? racingCars.hashCode() : 0;
    }
}
