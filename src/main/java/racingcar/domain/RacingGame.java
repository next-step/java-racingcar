package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final int ZERO = 0;
    private final String DELIMITER = ",";
    private final RacingCars racingCars;

    public RacingGame(String nameOfCars, MoveStrategy moveStrategy) {
        this.racingCars = new RacingCars(registerCar(splitCarName(nameOfCars)), moveStrategy);
    }

    private List<Car> registerCar(String[] nameOfCars) {
        return Arrays.stream(nameOfCars).map(Car::new).collect(Collectors.toList());
    }

    public void start() {
        racingCars.move();
    }

    public List<String> getWinner() {
        return racingCars.getWinner();
    }

    private String[] splitCarName(String nameOfCars) {
        if (nameOfCars.length() == ZERO) {
            throw new IllegalArgumentException("참가한 자동차가 없습니다.");
        }

        return nameOfCars.split(DELIMITER);
    }

    public RacingCars getRacingCars()
    {
        return racingCars;
    }
}
