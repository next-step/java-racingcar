package step1;

public final class IntegerFormulaNodeValue extends FormulaNodeValue<Integer> {
    public static final FormulaNodeValue<Integer> ZERO = new IntegerFormulaNodeValue(0);
    public static final FormulaNodeValue<Integer> ONE = new IntegerFormulaNodeValue(1);
    public static final FormulaNodeValue<Integer> TWO = new IntegerFormulaNodeValue(2);

    public IntegerFormulaNodeValue(final Integer value) {
        super(value);
    }

    @Override
    public int asInt() {
        return value;
    }

    @Override
    public long asLong() {
        return value;
    }

    @Override
    public Integer asType() {
        return value;
    }

    @Override
    public String asRaw() {
        return value.toString();
    }
}
