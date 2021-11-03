package racingcar.step2.operation;

public class Multiply extends AbstractOperation implements Operation {

    public final static String SIGN = "*";

    public Multiply(String left, String right) {
        super(left, right);
    }

    @Override
    public String operate() {
        return String.valueOf(left * right);
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
