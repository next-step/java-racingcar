package racing.domain;

import common.StringSpliter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private final int gameCount;
    private final CarMoveStrategy carMoveStrategy;
    private final List<Car> cars = new ArrayList<>();
    private int currentRound;

    public RacingGame(int carCount, int gameCount) {
        this(carCount, gameCount, new CarMoveStrategy(new Random()));
    }

    public RacingGame(int carCount, int gameCount, CarMoveStrategy carMoveStrategy) {
        this.gameCount = gameCount;
        this.carMoveStrategy = carMoveStrategy;
        this.currentRound = 0;
        initRacingCar(carCount);
    }

    public RacingGame(String userNameAnswer, int carCount, int gameCount, CarMoveStrategy carMoveStrategy) {
        this.gameCount = gameCount;
        this.carMoveStrategy = carMoveStrategy;
        this.currentRound = 0;

        String[] userNames = parseUserName(userNameAnswer);
        initRacingCar(userNames, carCount);
    }

    public boolean isProgress() {
        return this.getCurrentRound() < this.getGameCount();
    }

    public int getGameCount() {
        return gameCount;
    }

    public List<Car> getRacingCars() {
        return cars;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void doRacing() {
        cars.forEach(this::doGame);
        this.currentRound++;
    }

    public String getWinnersName() {
        List<String> userNameList = getWinners()
                .stream()
                .map(Car::getUserName)
                .collect(Collectors.toList());
        return String.join(",", userNameList);
    }

    private List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winCars = new ArrayList<>();

        List<Car> racingCars = getRacingCars();
        racingCars.stream()
                .filter(o -> o.getPosition() == maxPosition)
                .forEach(winCars::add);
        return winCars;
    }


    private String[] parseUserName(String userNameAnswer) {
        final String NAME_SPLIT_DELIMITER = ",";
        return StringSpliter.getSplittedString(userNameAnswer, NAME_SPLIT_DELIMITER);
    }

    private void initRacingCar(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    private void initRacingCar(String[] userNames, int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(userNames[i]));
        }
    }

    private void doGame(Car car) {
        int result = carMoveStrategy.getResult();
        car.move(result);
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        List<Car> racingCars = getRacingCars();
        for (Car racingCar : racingCars) {
            if (racingCar.getPosition() >= maxPosition) {
                maxPosition = racingCar.getPosition();
            }
        }
        return maxPosition;
    }
}
