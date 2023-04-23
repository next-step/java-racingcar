package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final int ZERO = 0;
    private final String DELIMITER = ",";
    private final RacingCars racingCars;
    private MoveStrategy moveStrategy;

    public RacingGame(String nameOfCars, MoveStrategy moveStrategy) {
        this.racingCars = new RacingCars(registerCar(splitCarName(nameOfCars)));
        this.moveStrategy = moveStrategy;
    }

    private List<Car> registerCar(String[] nameOfCars) {
        return Arrays.stream(nameOfCars).map(Car::new).collect(Collectors.toList());
    }

    public void start() {
        racingCars.move(moveStrategy);
    }

    public List<String> getWinner() {
        return racingCars.getWinner();
    }

    private String[] splitCarName(String nameOfCars) {
        if (nameOfCars.length() == ZERO) {
            throw new RuntimeException("player zero");
        }

        return nameOfCars.split(DELIMITER);
    }

    public RacingCars getRacingCars()
    {
        return racingCars;
    }
}
