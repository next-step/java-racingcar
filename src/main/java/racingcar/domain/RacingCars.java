package racingcar.domain;

import racingcar.utils.Const;
import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    public RacingCars whoIsWinners() {
        return new RacingCars(
                this.racingCars
                        .stream()
                        .filter(racingCar -> racingCar.isInPosition(getWinnerPosition()))
                        .collect(Collectors.toList())
        );
    }

    public List<String> getNames() {
        return racingCars
                .stream()
                .map(racingCar -> racingCar.getCarName())
                .collect(Collectors.toList());
    }

    public List<RacingCar> get() {
        return racingCars;
    }

    public RacingCarPositions moveCars() {
        List<RacingCarPosition> racingCarPositions = new ArrayList<>();
        racingCars
                .forEach(car -> {
                    RacingCar resultCar = carMove(car);
                    racingCarPositions.add(new RacingCarPosition(resultCar.getPosition()));
                });
        return new RacingCarPositions(racingCarPositions);
    }

    private RacingCar carMove(RacingCar racingCar) {
        int random = RandomUtils.generateRandomNum();
        racingCar.move(() -> racingCar.isMove(random));
        return racingCar;
    }

    private int getWinnerPosition() {
        return this.racingCars
                .stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
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

    @Override
    public String toString() {
        List<String> names =
                racingCars
                        .stream()
                        .map(racingCar -> racingCar.getCarName())
                        .collect(Collectors.toList());

        return String.join(Const.SYMBOL_COMMA, names);
    }
}
