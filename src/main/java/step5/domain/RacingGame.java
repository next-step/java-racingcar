package step5.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGame {

    private static final String DELIMITER = ",";
    private static final int IDENTITY = 0;

    private List<RacingCar> racingCars;
    private final MovingStrategy movingStrategy;

    private RacingGame(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public static RacingGame create(MovingStrategy movingStrategy) {
        return new RacingGame(movingStrategy);
    }

    public void readyRacingCars(String carName) {
        String[] carNames = convertToCarNames(carName);
        initRacingCars(carNames);
    }

    private String[] convertToCarNames(String carName) {
        if(Objects.isNull(carName) || carName.isEmpty()) {
            throw new IllegalArgumentException("경주할 자동차 이름을 반드시 입력해주세요.");
        }

        return carName.trim().split(DELIMITER);
    }

    private void initRacingCars(String[] carNames) {
        this.racingCars = Arrays.stream(carNames)
            .map(RacingCar::ready)
            .collect(Collectors.toList());
    }

    public List<RacingCar> startRacing() {
        moveForwardRacingCars();
        return convertToRacingCarList();
    }

    private List<RacingCar> convertToRacingCarList() {
        return racingCars.stream()
            .map(car -> new RacingCar(car.getName(), car.currentPosition()))
            .collect(Collectors.toList());
    }

    private List<RacingCar> moveForwardRacingCars() {
        racingCars.forEach(this::moveForward);

        return racingCars;
    }

    private void moveForward(RacingCar racingCar) {
        if (movingStrategy.isMovable()) {
           racingCar.forward();
        }
    }

    public String getWinners() {
        int maxPosition = getMaxPosition();

        return racingCars.stream()
            .filter(racingCar -> racingCar.isMaxPosition(maxPosition))
            .map(RacingCar::getName)
            .collect(Collectors.joining(DELIMITER));
    }

    private int getMaxPosition() {
        return racingCars.stream()
            .max(RacingCar::comparePosition)
            .get()
            .currentPosition();
    }
}