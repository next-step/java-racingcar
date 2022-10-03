package racingcar;

import racingcar.domain.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        View view = new View();

        CarCount carCount = new CarCount(view.inputCarCount());
        TrialCount trialCount = new TrialCount(view.inputTrialCount());

        Cars cars = new Cars(carCount.create());
        Generator generator = new RandomValueGenerator();
        List<Cars> trials = trialCount.start(cars, generator);

        view.printResult(trials);
    }
}
