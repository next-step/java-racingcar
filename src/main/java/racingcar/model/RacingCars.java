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
        validate(names);
        String[] namesArray = split(names);
        for (String name : namesArray) {
            racingCars.add(new RacingCar(name));
        }

        return new RacingCars(racingCars);
    }

    public void move(MovableStrategy movableStrategy) {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(movableStrategy);
        }
    }

    public RacingCars extractWinner() {
        List<RacingCar> winner = new ArrayList<>();
        this.getValue()
                .stream()
                .sorted(Comparator.comparing(RacingCar::getStatus).reversed())
                .forEach((racingCar) -> {
                    addWinner(winner, racingCar);
                });
        return new RacingCars(winner);
    }

    private void addWinner(List<RacingCar> racingCars, RacingCar racingCar) {
        if (racingCars.isEmpty() || racingCar.getStatus() == racingCars.get(0).getStatus()) {
            racingCars.add(racingCar);
        }
    }

    private static void validate(String value) {
        if (value.length() <= 0) {
            throw new IllegalStateException(INPUT_COUNT_ERROR_MESSAGE);
        }
    }

    private static String[] split(String value) {
        return value.split(",");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars that = (RacingCars) o;
        return Objects.equals(racingCars, that.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars);
    }
}
