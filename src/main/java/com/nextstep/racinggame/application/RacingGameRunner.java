package com.nextstep.racinggame.application;

import com.nextstep.racinggame.domain.*;
import com.nextstep.racinggame.view.InputView;
import com.nextstep.racinggame.view.OutputView;

import java.util.List;

public class RacingGameRunner {
    private static final MovePolicy RANDOM_MOVE_POLICY = new RandomMovePolicy();

    public static void main(String[] args) {
        OutputView.printCarDemandMessage();
        List<Name> names = InputView.getCarNames();

        OutputView.printRaceDemandMessage();
        int raceCount = InputView.getRacingCount();

        run(names, raceCount);
    }

    private static void run(final List<Name> names, final int raceDemand) {
        Cars cars = CarsFactory.createCars(names);

        OutputView.printResultHeader();
        for (int i = 0; i < raceDemand; i++) {
            Cars racedCars = cars.move(RANDOM_MOVE_POLICY);

            OutputView.printGameProgress(racedCars);

            cars = racedCars;
        }

        OutputView.printWinnerResult(cars.calculateMostMovedCars());
    }
}
