package com.jaenyeong.mission2.racingcar;

import com.jaenyeong.mission2.racingcar.domain.Cars;
import com.jaenyeong.mission2.racingcar.dto.RacingHistoryDto;
import com.jaenyeong.mission2.racingcar.view.Input;
import com.jaenyeong.mission2.racingcar.view.InputView;
import com.jaenyeong.mission2.racingcar.view.Output;
import com.jaenyeong.mission2.racingcar.view.OutputView;

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
        final Cars cars = processSetCountOfCars();

        racingGivenNumberOfTimes(processSetRaceTryTimes(), cars);

        processResultOfRacing(cars);
    }

    private Cars processSetCountOfCars() {
        output.printHowManyUseCars();
        return getCars(input.inputHowManyUseCars());
    }

    protected Cars getCars(final int howManyUseCars) {
        return new Cars(howManyUseCars);
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
        output.printExecutionResult();
        output.printAllRacingHistoriesResult(getHistoryDto(cars));
    }

    protected RacingHistoryDto getHistoryDto(final Cars cars) {
        return new RacingHistoryDto((currentTurn), cars);
    }

    public int getCurrentTurn() {
        return currentTurn;
    }
}
