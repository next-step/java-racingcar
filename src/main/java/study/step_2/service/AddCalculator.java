package study.step_2.service;

import study.step_2.domain.Calculate;

public class AddCalculator {

    private final Calculate calculate;

    public AddCalculator(Calculate calculate) {
        this.calculate = calculate;
    }

    public int executeAdd(String express) {
        return calculate.splitAndSum(express);
    }
}
