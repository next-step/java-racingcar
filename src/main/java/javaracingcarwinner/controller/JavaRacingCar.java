package javaracingcarwinner.controller;

import javaracingcarwinner.dto.GameSettingDto;
import javaracingcarwinner.entity.RacingCar;
import javaracingcarwinner.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaRacingCar {
    private static final String SPLIT_DELIMITER = ",";


    private final List<RacingCar> cars = new ArrayList<>();
    private final ResultView resultView;

    private int tryCount;

    public JavaRacingCar(GameSettingDto settings, ResultView resultView) {
        initCars(toList(split(settings.text())));
        validateTryCount(settings.tryCount());
        this.tryCount = settings.tryCount();
        this.resultView = resultView;
        start();
    }

    private void start() {
        this.resultView.startMessage();
        startRound();
        this.resultView.printWinners(whoIsWinners(this.cars));
    }

    private void startRound() {
        for (int i = 0; i < this.tryCount; i++) {
            startRoundEachCar();
            resultView.printRound(this.cars);
        }
    }

    private void startRoundEachCar() {
        for (int i = 0; i < this.cars.size(); i++) {
            decidedMoveCar(i);
        }
    }

    private void decidedMoveCar(int carIndex) {
        RacingCar racingCar = this.cars.get(carIndex);
        racingCar.move();
    }

    private String[] split(String text) {
        return text.split(SPLIT_DELIMITER);
    }

    private List<String> toList(String[] array) {
        return Arrays.stream(array).collect(Collectors.toList());
    }

    private void initCars(List<String> names) {
        for (String name : names) {
            this.cars.add(new RacingCar(name));
        }
    }



    private void validateTryCount(int tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException("음수 입력");
        }
    }

    public List<RacingCar> cars() {
        return this.cars;
    }

    public int tryCount() {
        return this.tryCount;
    }

    public static List<RacingCar> whoIsWinners(List<RacingCar> cars) {
        final List<RacingCar> winners = new ArrayList<>();

        final int winnerLocation = winnerLocation(cars);

        for (RacingCar car : cars) {
            addWinner(winners, winnerLocation, car);
        }

        return winners;
    }

    private static void addWinner(List<RacingCar> winners, int winnerLocation, RacingCar car) {
        if (isWinner(winnerLocation, car.location())) {
            winners.add(car);
        }
    }

    private static boolean isWinner(int winnerLocation, int location) {
        return winnerLocation == location;
    }

    private static int winnerLocation(List<RacingCar> cars) {
        int maxLocation = 0;

        for (RacingCar car : cars) {
            maxLocation = car.max(maxLocation);
        }
        return maxLocation;
    }

}
