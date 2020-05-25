package racing.controller;

import racing.domain.Car;
import racing.domain.RacingCar;
import racing.domain.RacingGameResult;
import racing.util.Dice;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int MIN_SETTING_NUMBER = 1;
    private final int round;
    private final RacingCar racingCar;
    private final RacingGameResult racingGameResult;

    public RacingGame(int carCount, int round) {
        validation(carCount, round);
        this.round = round;
        this.racingCar = new RacingCar(carCount);
        this.racingGameResult = new RacingGameResult();
    }

    private void validation(int carCount, int round) {
        if (carCount < MIN_SETTING_NUMBER || round < MIN_SETTING_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public RacingGameResult playGame() {
        for (int i = 0; i < round; i++) {
            List<Integer> roundResult = playRound(racingCar.getCarList());
            racingGameResult.addResult(roundResult);
        }

        return racingGameResult;
    }

    private List<Integer> playRound(List<Car> carList) {
        return carList.stream().map(car -> car.move(Dice.cast())).collect(Collectors.toList());
    }
}
