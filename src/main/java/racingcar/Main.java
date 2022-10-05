package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Generator;
import racingcar.domain.RandomValueGenerator;
import racingcar.domain.TrialCount;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        View view = new View();

        Cars cars = Cars.create("a,b,c");
        TrialCount trialCount = new TrialCount(view.inputTrialCount());

        Generator generator = new RandomValueGenerator();
        List<Cars> trials = trialCount.start(cars, generator);

        view.printResult(trials);
    }
}
