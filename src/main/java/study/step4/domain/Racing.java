package study.step4.domain;

import study.step4.NumberGenerator;

import static study.step4.view.ResultView.showProgress;

public class Racing {

    private final NumberGenerator numberGenerator;

    public Racing(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Cars run(Rule rule) {
        return start(rule);
    }

    private Cars start(Rule rule) {
        Cars cars = rule.getCars();
        for (int i = 0; i < rule.getMovingTimes(); i++) {
            moveCars(cars);
            showProgress(cars);
        }
        return cars.winners();
    }

    private void moveCars(Cars cars) {
        for (Car car: cars.getCars()) {
            car.move(numberGenerator.generate());
        }
    }

}
