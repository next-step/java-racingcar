package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.TrialCount;
import racingcar.domain.Winners;
import racingcar.generator.Generator;
import racingcar.generator.RandomValueGenerator;

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
        view.printWinners(Winners.find(cars));
    }
}
