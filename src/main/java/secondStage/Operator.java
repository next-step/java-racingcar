package secondStage;

import secondStage.exception.OperatorException;

import java.util.ArrayList;
import java.util.List;

/**
 * 연산자를 추출하는 클래스
 */
public class Operator {

    private final List<String> operators = new ArrayList<>();
    private final String[] values;

    public Operator(String[] values) {
        this.values = values;
        createOperator();
    }

    /**
     * 연산자 생성
     */
    private void createOperator() {
        int length = values.length;
        for (int i = 1; i < length; i += 2) {
            validateOperator(values[i]);
            addOperator(values[i]);
        }
    }

    /**
     * 사칙 연산자가 아닌게 있으면 예외
     */
    private void validateOperator(String value) {
        if (!("+".equals(value) || "-".equals(value) || "*".equals(value)|| "/".equals(value))) {
            throw new OperatorException();
        }
    }

    /**
     * operands add
     */
    private void addOperator(String value) {
        operators.add(value);
    }

    public List<String> getOperators() {
        return operators;
    }
}
