package study.step5;

import study.step5.domain.Cars;
import study.step5.domain.Racing;
import study.step5.domain.dto.Rule;

import static study.step5.view.InputView.getRule;
import static study.step5.view.ResultView.showProgress;
import static study.step5.view.ResultView.showResult;

public class Controller {

    public static void main(String[] args) {
        Rule rule = getRule();

        Racing racing = new Racing(new RandomNumberGenerator());

        Cars cars = rule.cars();
        for (int i = 0; i < rule.getMovingTimes(); i++) {
            racing.moveCars(cars);
            showProgress(cars);
        }

        Cars winners = cars.winners();
        showResult(winners);
    }
}
