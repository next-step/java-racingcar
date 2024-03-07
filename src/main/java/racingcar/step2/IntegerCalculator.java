package racingcar.step2;

import java.util.List;

public class IntegerCalculator {

    public int sum(List<Integer> tokens) {
        return tokens.stream()
                .reduce(0, Integer::sum);
    }
}
