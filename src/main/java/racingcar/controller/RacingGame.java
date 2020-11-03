package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.exception.InvalidTryCountException;
import racingcar.domain.strategy.RacingStrategy;
import racingcar.domain.strategy.RandomRacingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RacingGame {

    private RacingGame() {

    }

    public static void main(String[] args) {
        PrintWriter output = new PrintWriter(System.out, true);
        InputView inputView = new InputView(new Scanner(System.in), output);
        ResultView resultView = new ResultView(output);

        execute(output, inputView, resultView);
    }

    public static void execute(PrintWriter output, InputView inputView, ResultView resultView) {
        RacingStrategy racingStrategy = new RandomRacingStrategy();
        Cars cars = Cars.ofNames(inputView.getCarNames());
        Integer tryCount = inputView.getTryCountFromInput();
        validateTryCount(tryCount);
        resultView.showResultHeader();
        IntStream.range(0, tryCount)
                .forEach(i -> {
                    cars.move(racingStrategy);
                    resultView.showAtStep(cars.getRecords());
                });
        resultView.showWinner(cars.getWinnerRecord());
        output.close();
    }

    private static void validateTryCount(Integer count) {
        if (count <= 0) {
            throw new InvalidTryCountException();
        }
    }

}
