package study.step4;

import java.util.List;

import static study.step4.InputView.requestRule;

public class Step4Application {

    public static void main(String[] args) {
        Racing racing = new Racing(new RandomNumberGenerator());
        Rule rule = requestRule();
        List<Car> result = racing.run(rule);
    }
}
