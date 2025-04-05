package racingcar.controller;

import java.util.List;

import racingcar.domain.Cars;
import racingcar.domain.RaceRecords;
import racingcar.utils.NumberUtils;
import racingcar.utils.StringUtils;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {

    public void play() {
        List<String> carNames = StringUtils.splitByComma(InputView.getCarNames());
        Cars cars = Cars.create(carNames);

        int tryCount = NumberUtils.toInt(InputView.getTryCount());

        RaceRecords raceRecords = RaceRecords.init(cars);
        for (int i = 0; i < tryCount; i++) {
            cars = cars.move();
            raceRecords.record(cars);
        }

        ResultView.printResult();
        raceRecords.getValues()
            .forEach(raceRecord -> {
                raceRecord.getCars()
                    .getValues()
                    .forEach(car -> ResultView.print(car.getName(), car.getPositionValue()));
                ResultView.printNewLine();
            });

        ResultView.printWinner(cars.getWinnerNames());
    }
}
