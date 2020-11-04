import java.util.*;

public interface Calculator {

    int calculate(String expression);

    class Default implements Calculator {

        private ExpressionParser expressionParser = new ExpressionParser.Default();

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
            return op.execute(value1, value2);
        }

        private void parseExpression(String expression, Queue<Integer> operands, Queue<Operator> operators) {
            ParsedExpression result = expressionParser.parse(expression);
            result.operands.forEach(operand -> operands.offer(operand.getValue()) );
            result.operators.forEach(operator -> operators.offer(operator));
        }
    }
}
