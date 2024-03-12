package race;

import java.util.ArrayList;
import java.util.List;
import race.domain.Car;
import race.domain.Cars;
import race.view.InputView;
import race.view.ResultView;

public class RacingCarApplication {

    private final static int NUMBER_OR_CAR_INDEX = 0;
    private final static int COUNT_OF_TRIAL = 1;

    public static void main(String[] args) {
        List<Integer> input = InputView.requestInput();
        ResultView.start();
        Cars cars = Cars.createInstance(input.get(NUMBER_OR_CAR_INDEX));
        racing(cars, input.get(COUNT_OF_TRIAL));
    }

    private static void racing(Cars cars, int countOfTrial) {
        for (int i = 0; i < countOfTrial; i++) {
            cars.moveCars();
            ResultView.showProcess(cars);
        }
    }
}
