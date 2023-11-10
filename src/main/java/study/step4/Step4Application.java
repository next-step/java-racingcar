package study.step4;

import java.util.List;

import study.step4.domain.*;

import static study.step4.view.InputView.requestRule;
import static study.step4.view.ResultView.getWinners;
import static study.step4.view.ResultView.show;

public class Step4Application {

    public static void main(String[] args) {
        Racing racing = new Racing(new RandomNumberGenerator());
        Rule rule = requestRule();
        List<Car> result = racing.run(rule);
        show(getWinners(result));
    }
}
