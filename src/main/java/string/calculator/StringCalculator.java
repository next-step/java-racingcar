package string.calculator;


import java.util.LinkedList;


public class StringCalculator {

    public String getResult(String input, OperationsDivision operationsDivision) {
        if (StringUtils.isEmpty(input)) {
            throw new IllegalArgumentException("null 혹은 빈 값이 올 수 없습니다.");
        }

        LinkedList<String> operands = operationsDivision.extractOperands(input);
        LinkedList<Operator> operators = operationsDivision.extractOperators(input);

        return calculateNumbers(operands, operators);
    }

    private String calculateNumbers(LinkedList<String> operands, LinkedList<Operator> operators) {
        if (operands.size() < operators.size()) {
            throw new IllegalArgumentException("잘못된 입력 입니다.");
        }

        return operands
                .stream()
                .reduce(operands.removeFirst(), (firstNum, secondNum) ->
                        operators.removeFirst().calculate(firstNum, secondNum));
    }
}
