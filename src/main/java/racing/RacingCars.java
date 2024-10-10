package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCars {

    private final RacingCar[] racingCars;

    public RacingCars(RacingCar[] racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars(String totalCarNames) {
        String[] carNames = splitCarNames(totalCarNames);
        this.racingCars = new RacingCar[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            racingCars[i] = new RacingCar(carNames[i], new Operator());
        }
    }

    public void racing() {
        for (RacingCar racingCar : this.racingCars) {
            racingCar.race();
        }
    }

    public RacingCarPosition[] getPositions() {
        RacingCarPosition[] result = new RacingCarPosition[this.racingCars.length];
        for (int i = 0 ; i < this.racingCars.length; i++ ) {
            RacingCar racingCar = this.racingCars[i];
            result[i] = racingCar.getPosition();
        }
        return result;
    }

    public List<RacingCar> findWinners() {
        int max = 0;
        for (RacingCar racingCar : this.racingCars) {
            max = Math.max(max, racingCar.getPosition().getCarPosition());
        }

        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar racingCar : this.racingCars) {
            winners.add(max == racingCar.getPosition().getCarPosition() ? racingCar : null);
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
