package racingcar;

import racingcar.domain.CarCount;
import racingcar.domain.Cars;
import racingcar.domain.TrialCount;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        View view = new View();

        CarCount carCount = new CarCount(view.inputCarCount());
        TrialCount trialCount = new TrialCount(view.inputTrialCount());

        Cars cars = new Cars(carCount.create());
        List<Cars> trials = trialCount.start(cars);

        view.printResult(trials);
    }
}
