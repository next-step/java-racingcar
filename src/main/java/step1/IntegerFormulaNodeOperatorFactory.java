package step1;

import static step1.OperationType.DIVIDE;
import static step1.OperationType.MINUS;
import static step1.OperationType.MULTIPLY;
import static step1.OperationType.PLUS;

public class IntegerFormulaNodeOperatorFactory {
    public static FormulaNodeOperator<Integer> plus() {
        return mixIn()
                .type(PLUS)
                .operation((a, b) -> wrap(Math.addExact(a.asInt(), b.asInt())));
    }

    public static FormulaNodeOperator<Integer> plusIgnoreOverflow() {
        return mixIn()
                .type(PLUS)
                .operation((a, b) -> wrap(a.asInt() + b.asInt()));
    }

    public static FormulaNodeOperator<Integer> minus() {
        return mixIn()
                .type(MINUS)
                .operation((a, b) -> wrap(Math.subtractExact(a.asInt(), b.asInt())));
    }

    public static FormulaNodeOperator<Integer> minusIgnoreOverflow() {
        return mixIn()
                .type(MINUS)
                .operation((a, b) -> wrap(a.asInt() - b.asInt()));
    }

    public static FormulaNodeOperator<Integer> multiply() {
        return mixIn()
                .type(MULTIPLY)
                .operation((a, b) -> wrap(Math.multiplyExact(a.asInt(), b.asInt())));
    }

    public static FormulaNodeOperator<Integer> multiplyIgnoreOverflow() {
        return mixIn()
                .type(MULTIPLY)
                .operation((a, b) -> wrap(a.asInt() * b.asInt()));
    }

    public static FormulaNodeOperator<Integer> divide() {
        return mixIn()
                .type(DIVIDE)
                .operation((a, b) -> wrap(a.asInt() / b.asInt()));
    }

    public static FormulaNodeOperator<Integer> divideIgnoreException(final int exceptionalDefaultValue) {
        return mixIn()
                .type(DIVIDE)
                .operation((a, b) -> {
                    try {
                        return wrap(a.asInt() / b.asInt());
                    } catch (ArithmeticException ignore) {
                        return wrap(exceptionalDefaultValue);
                    }
                });
    }

    private static FormulaNodeValue<Integer> wrap(final int value) {
        return new IntegerFormulaNodeValue(value);
    }

    private static MixableFormulaNodeOperator mixIn() {
        return new MixableFormulaNodeOperator();
    }

    private interface MixableOperation {
        FormulaNodeValue<Integer> operate(final FormulaNodeValue<Integer> base,
                                          final FormulaNodeValue<Integer> other);
    }

    private static final class MixableFormulaNodeOperator implements FormulaNodeOperator<Integer> {
        private OperationType type;
        private MixableOperation mixableOperation;

        private MixableFormulaNodeOperator type(final OperationType type) {
            this.type = type;
            return this;
        }

        private MixableFormulaNodeOperator operation(final MixableOperation mixableOperation) {
            this.mixableOperation = mixableOperation;
            return this;
        }

        @Override
        public FormulaNodeValue<Integer> operate(final FormulaNodeValue<Integer> base,
                                                 final FormulaNodeValue<Integer> other) {
            return mixableOperation.operate(base, other);
        }

        @Override
        public String asRaw() {
            return type.text();
        }
    }
}
