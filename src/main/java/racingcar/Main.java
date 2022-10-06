package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Generator;
import racingcar.domain.RandomValueGenerator;
import racingcar.domain.TrialCount;

public class Main {
    public static void main(String[] args) {
        View view = new View();

        Cars cars = Cars.create(view.inputCarName());
        TrialCount trialCount = new TrialCount(view.inputTrialCount());
        Generator generator = new RandomValueGenerator();

        view.printResult();
        while (trialCount.isRemain()) {
            cars.move(generator);
            view.printTrial(cars);
            trialCount.decrease();
        }
        view.printWinners(cars.findWinners());
    }
}
