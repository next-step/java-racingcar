package racingcar.step2.operation;

import racingcar.step2.CalculatorValidation;

public class Divide extends AbstractOperation implements Operation {

    public final static String SIGN = "/";

    public Divide(String left, String right) {
        super(left, right);
    }

    @Override
    public String operate() {
        CalculatorValidation.divideCheck(left, right);
        return String.valueOf(left / right);
    }

    @Override
    public String getSign() {
        return SIGN;
    }

    @Override
    public boolean isSign(String sign) {
        return SIGN.equals(sign);
    }


}
