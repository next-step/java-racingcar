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
    private int currentTurn = 1;
    private Cars cars;

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
        output.printHowManyUseCars();
        final int howManyUseCars = input.inputHowManyUseCars();
        this.cars = new Cars(howManyUseCars);

        output.printHowManyTryTimes();
        final int howManyTryTimes = input.inputHowManyTryTimes();
        racingGivenNumberOfTimes(howManyTryTimes);

        output.printExecutionResult();
        output.printAllRacingHistoriesResult(new RacingHistoryDto(howManyTryTimes, cars));
    }

    private void racingGivenNumberOfTimes(final int tryTimes) {
        for (int i = 0; i < tryTimes; i++) {
            currentTurn++;
            this.cars.moveRacingCars();
        }
    }
}
