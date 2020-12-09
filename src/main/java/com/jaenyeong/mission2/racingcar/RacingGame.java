package com.jaenyeong.mission2.racingcar;

import com.jaenyeong.mission2.racingcar.domain.Cars;
import com.jaenyeong.mission2.racingcar.dto.RacingHistoryDto;
import com.jaenyeong.mission2.racingcar.view.Input;
import com.jaenyeong.mission2.racingcar.view.InputView;
import com.jaenyeong.mission2.racingcar.view.Output;
import com.jaenyeong.mission2.racingcar.view.OutputView;

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
        final Cars cars = setCarsByNamesOfCars();

        racingGivenNumberOfTimes(setRaceTryTimes(), cars);

        resultOfRacing(cars);
    }

    private Cars setCarsByNamesOfCars() {
        output.printNamesOfTheCarsToBeRaced();

        return createCarsInstance(input.inputNamesOfTheCarsToBeRaced());
    }

    protected Cars createCarsInstance(final List<String> nameOfCars) {
        return new Cars(nameOfCars);
    }

    protected int setRaceTryTimes() {
        output.printHowManyTryTimes();
        return input.inputHowManyTryTimes();
    }

    protected void racingGivenNumberOfTimes(final int tryTimes, final Cars cars) {
        for (int i = 0; i < tryTimes; i++) {
            currentTurn++;
            cars.moveRacingCars();
        }
    }

    private void resultOfRacing(final Cars cars) {
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
