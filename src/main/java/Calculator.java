import java.util.*;
import java.util.function.BiFunction;

public interface Calculator {

    int calculate(String expression);

    class Default implements Calculator {

        private List<Operator> supportedOperators = Arrays.asList(Operator.Plus, Operator.Minus, Operator.Multiple, Operator.Divide);

        private ExpressionValidator expressionValidator = new DefaultExpressionValidator();

        enum Operator {
            Plus("+", (value1, value2) -> value1 + value2),
            Minus("-", (value1, value2) -> value1 - value2),
            Multiple("*", (value1, value2) -> value1 * value2),
            Divide("/", (value1, value2) -> value1 / value2);

            private String sign;

            private BiFunction<Integer, Integer, Integer> executor;

            Operator(String sign, BiFunction<Integer, Integer, Integer> executor) {
                this.sign = sign;
                this.executor = executor;
            }

            public static Operator valueOfSign(String sign) {
                Operator[] ops = Operator.values();
                for (int i = 0; i < ops.length; i++) {
                    if (ops[i].sign.equals(sign)) return ops[i];
                }
                throw new EnumConstantNotPresentException(Operator.class, sign);
            }
        }

        @Override
        public int calculate(String expression) {
            Deque<Integer> operands = new LinkedList<>();
            Queue<Operator> operators = new LinkedList<>();

            parseExpression(expression, operands, operators);

            Integer result = 0;
            Iterator<Operator> it = operators.iterator();

            while (it.hasNext()) {
                result = executeOperator(it.next(), operands.poll(), operands.poll());
                operands.addFirst(result);
            }

            return result;
        }

        private Integer executeOperator(Operator op, Integer value1, Integer value2) {
            return op.executor.apply(value1, value2);
        }

        private void parseExpression(String expression, Queue<Integer> operands, Queue<Operator> operators) {
            validateExpression(expression);

            String[] parts = expression.split(" ");

            for (int i = 0; i < parts.length; i++) {
                if (isOperator(parts[i])) {
                    operators.offer(Operator.valueOfSign(parts[i]));
                } else if (isNumeric(parts[i])) {
                    operands.offer(Integer.valueOf(parts[i]));
                } else {
                    throw new IllegalArgumentException(expression);
                }
            }
        }

        private boolean isNumeric(String value) {
            try {
                Integer.parseInt(value);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        private boolean isOperator(String value) {
            try {
                return supportedOperators.contains(Operator.valueOfSign(value));
            } catch (EnumConstantNotPresentException e) {
                return false;
            }
        }

        private void validateExpression(String expression) {
            try {
                expressionValidator.validate(expression);
            } catch ( InvalidExpressionException e ){
                throw new IllegalArgumentException(e.getMessage(), e);
            }
        }

        private class DefaultExpressionValidator implements ExpressionValidator {

            @Override
            public void validate(String expression) throws InvalidExpressionException {
                if (isNullOrBlank(expression)
                        || !isStartByNumericOperand(expression)
                ) throw new InvalidExpressionException(expression);
            }

            private boolean isNullOrBlank(String expression) {
                return StringUtils.isNullOrBlank(expression);
            }

            private boolean isStartByNumericOperand(String expression) {
                try {
                    Integer.parseInt(String.valueOf(expression.split(" ")[0]));
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
    }
}
