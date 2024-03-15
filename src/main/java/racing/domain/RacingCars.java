package racing.domain;

import racing.domain.RacingCar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final String NAME_DELIMITER = ",";
    private final List<RacingCar> racingCarList;

    public RacingCars(String names) {
        if (isNullOrBlank(names)) {
            throw new IllegalArgumentException();
        }

        this.racingCarList = Arrays.stream(toNameArray(names))
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public RacingCars(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public int size() {
        return racingCarList.size();
    }

    public int getMaxPosition() {
        return Collections.max(
                racingCarList.stream()
                        .map(RacingCar::getPosition)
                        .collect(Collectors.toList()));
    }

    public List<String> getWinnerNames() {
        int highScore = getMaxPosition();

        return racingCarList.stream()
                .filter(car -> car.isWinner(highScore))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private boolean isNullOrBlank(String name) {
        return name == null || name.isBlank();
    }

    private String[] toNameArray(String names) {
        return names.split(NAME_DELIMITER);
    }
}
