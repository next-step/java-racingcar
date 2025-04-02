package racingcar;

import java.util.List;

import racingcar.domain.*;
import racingcar.utils.NumberUtils;
import racingcar.utils.StringUtils;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCar {

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        List<String> carNames = StringUtils.splitByComma(InputView.getCarNames());
        Cars cars = Cars.create(carNames);

        int tryCount = NumberUtils.toInt(InputView.getTryCount());

        RaceRecords raceRecords = RaceRecords.init(cars);
        for (int i = 0; i < tryCount; i++) {
            cars = cars.move();
            raceRecords.record(cars);
        }
        ResultView.printRecords(raceRecords);

        ResultView.printWinner(cars.getWinnerNames());
    }
}
