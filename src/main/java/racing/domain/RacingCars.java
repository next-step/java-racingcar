package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars(String totalCarNames) {
        String[] carNames = splitCarNames(totalCarNames);
        this.racingCars = new ArrayList<>();
        for (String carName : carNames) {
            this.racingCars.add(new RacingCar(carName, new Operator()));
        }
    }

    public void racing() {
        for (RacingCar racingCar : this.racingCars) {
            racingCar.race();
        }
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public List<RacingCar> findWinners() {
        int max = 0;
        for (RacingCar racingCar : this.racingCars) {
            max = Math.max(max, racingCar.getCurrentPosition());
        }

        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar racingCar : this.racingCars) {
            winners.add(max == racingCar.getCurrentPosition() ? racingCar : null);
        }

        return winners.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    private String[] splitCarNames(String totalCarNames) {
        String[] carNames = totalCarNames.split(",");
        for (String carName : carNames) {
            validateCarName(carName);
        }
        return carNames;
    }

    private void validateCarName(String carName) {
        if (carName != null && carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

}
