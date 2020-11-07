package racingcar;

import racingcar.external.InputView;
import racingcar.external.ResultView;
import racingcar.model.Car;
import racingcar.dto.RaceReadyValue;
import racingcar.model.Motor;
import racingcar.model.RandomMove;

import java.util.List;

public class RacingCarApplication {

    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();

    private static final String INPUT_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final String RACE_TREM = "********************";


    public static void main(String[] args) {
        RaceReadyValue raceReadyValue = input();
        Motor motor = new RandomMove();

        List<Car> cars = RacingCarService.initialCars(raceReadyValue.getCarCount(), motor);

        for (int x = 0; x < raceReadyValue.getTryCount(); x++) {
            RacingCarService.startRaceByStep(cars);
            output(cars);
        }
    }

    public static RaceReadyValue input() {
        int carCount = inputView.input(INPUT_CAR_COUNT);
        int tryCount = inputView.input(INPUT_TRY_COUNT);

        return new RaceReadyValue(carCount, tryCount);
    }

    public static void output(List<Car> cars) {
        for (Car car : cars) {
            resultView.out(car);
        }
        resultView.out(RACE_TREM);
    }
}
