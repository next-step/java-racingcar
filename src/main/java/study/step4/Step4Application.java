package study.step4;

import study.step4.domain.*;

import static study.step4.view.InputView.requestRule;
import static study.step4.view.ResultView.showResult;

public class Step4Application {

    public static void main(String[] args) {
        Racing racing = new Racing(new RandomNumberGenerator());
        Rule rule = requestRule();
        Cars cars = racing.run(rule);
        showResult(cars.winners());
        
    }
}
