package com.jaenyeong.mission2.racingcar;

import com.jaenyeong.mission2.racingcar.domain.Cars;
import com.jaenyeong.mission2.racingcar.dto.RacingHistoryDto;
import com.jaenyeong.mission2.racingcar.view.Input;
import com.jaenyeong.mission2.racingcar.view.InputView;
import com.jaenyeong.mission2.racingcar.view.Output;
import com.jaenyeong.mission2.racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private final Output output;
    private final Input input;
    private int currentTurn = 0;

    public RacingGame() {
        this.output = new OutputView();
        this.input = new InputView(this.output);
    }

    public void start() {
        try {
            runningGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void runningGame() {
        final Cars cars = processSetCarsByNamesOfCars();

        racingGivenNumberOfTimes(processSetRaceTryTimes(), cars);

        processResultOfRacing(cars);
    }

    private Cars processSetCarsByNamesOfCars() {
        output.printNamesOfTheCarsToBeRaced();
        String carNames = input.inputNamesOfTheCarsToBeRaced();

        return getCars(Arrays.asList(carNames.split(",")));
    }

    protected Cars getCars(final List<String> nameOfCars) {
        return new Cars(nameOfCars);
    }

    protected int processSetRaceTryTimes() {
        output.printHowManyTryTimes();
        return input.inputHowManyTryTimes();
    }

    protected void racingGivenNumberOfTimes(final int tryTimes, final Cars cars) {
        for (int i = 0; i < tryTimes; i++) {
            currentTurn++;
            cars.moveRacingCars();
        }
    }

    private void processResultOfRacing(final Cars cars) {
        final RacingHistoryDto historyDto = getHistoryDto(cars);

        output.printExecutionResult();
        output.printAllRacingHistoriesResult(historyDto);
        output.printWinner(historyDto);
    }

    protected RacingHistoryDto getHistoryDto(final Cars cars) {
        return new RacingHistoryDto((currentTurn), cars);
    }

    public int getCurrentTurn() {
        return currentTurn;
    }
}
