package step2;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public interface ExpressionParser {

    /**
     * expression 유효성을 검증하고 피연산자와 연산자로 분리합니다.
     *
     * 분리된 피연산자와 연산자는 step2.ParsedExpression 에 담아서 돌려줍니다.
     */
    ParsedExpression parse(String expression);

    class Default implements ExpressionParser{

        private ExpressionValidator validator = new DefaultExpressionValidator();

        @Override
        public ParsedExpression parse(String expression) {
            validate(expression);

            String[] parts = expression.split(" ");

            try {
                ParsedExpression result = new ParsedExpression();
                Arrays.stream(parts).forEach( part -> {
                    result.addPart(new ExpressionPartFactory().create(part));
                });
                return result;
            } catch ( RuntimeException e ){
                throw new IllegalArgumentException(e.getMessage(), e.getCause() == null ? e : e.getCause());
            }

        }

        private void validate(String expression) {
            try{
                validator.validate(expression);
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

class ParsedExpression {
    Deque<Operand> operands = new LinkedList<>();
    Queue<Operator> operators = new LinkedList<>();

    public void addPart(ExpressionPart part) {
        if( part.type() == ExpressionPart.Type.Operand ){
            operands.offer((Operand)part);
        } else {
            operators.offer((Operator)part);
        }
    }
}

