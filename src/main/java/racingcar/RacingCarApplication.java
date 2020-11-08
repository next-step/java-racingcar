package racingcar;

import racingcar.dto.RaceReadyValue;
import racingcar.external.InputChannel;
import racingcar.external.InputView;
import racingcar.external.OuputChannel;
import racingcar.external.ResultView;
import racingcar.model.Cars;
import racingcar.model.Motor;
import racingcar.model.RandomMove;

import java.util.stream.IntStream;

public class RacingCarApplication {

    private static final int RANGE_START_NUM = 0;

    public static void main(String[] args) {
        RaceReadyValue raceReadyValue = InputView.input(new InputChannel());
        Motor motor = new RandomMove();

        Cars cars = Cars.of(raceReadyValue.getCarCount(), motor);

        IntStream.range(RANGE_START_NUM, raceReadyValue.getTryCount())
                .forEach(i -> {
                    cars.run();
                    ResultView.output(new OuputChannel(), cars);
                });
    }
}
