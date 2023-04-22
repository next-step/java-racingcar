package racingcar.domain;

import racingcar.dto.RandomValue;
import racingcar.util.OutputView;

import java.util.*;

public class Racing {

    public static void runRacing(List<Car> carList, int tryNumber) {
        OutputView.resultIntro();
        for (int i = 0; i < tryNumber; i++) {
            runCarsForOneTurn(carList);
            OutputView.printInput("\n");
        }
    }

    private static void runCarsForOneTurn(List<Car> carList) {
        carList.stream().forEach(car -> {
            car.move(new RandomValue());
            OutputView.printCarTraceUntilNow(car);
        });
    }
}
