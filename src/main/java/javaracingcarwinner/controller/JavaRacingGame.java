package javaracingcarwinner.controller;

import javaracingcarwinner.dto.GameSettingDto;
import javaracingcarwinner.entity.RacingCar;
import javaracingcarwinner.entity.Round;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaRacingGame {
    private static final String SPLIT_DELIMITER = ",";

    private final List<RacingCar> cars = new ArrayList<>();
    private final List<Round> rounds = new ArrayList<>();
    private final int tryCount;

    public JavaRacingGame(GameSettingDto settings) {
        initCars(toList(split(settings.getText())));
        validateTryCount(settings.getTryCount());
        this.tryCount = settings.getTryCount();
        gameStart();
    }

    public List<Round> endGame() {
        return this.rounds;
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

    private void validateTryCount(int tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException("음수 입력");
        }
    }

    private void gameStart() {
        for (int i = 0; i < this.tryCount; i++) {
            this.rounds.add(new Round(this.cars));
        }
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

    public List<RacingCar> getCars() {
        return cars;
    }
}
