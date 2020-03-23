package stringcalculator.domain;

public class NumbersMock extends Numbers {
    public NumbersMock() {
        super("1".split(Constant.BLANK));
    }

    @Override
    public boolean isNumber(String expression) {
        return super.isNumber(expression);
    }
}
