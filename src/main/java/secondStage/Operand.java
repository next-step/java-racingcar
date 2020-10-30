package secondStage;

import java.util.ArrayList;
import java.util.List;

/**
 * 피연산자를 추출하는 클래스
 */
public class Operand {

    private final List<Integer> operands = new ArrayList<>();
    private final String[] values;

    public Operand(String[] values) {
        this.values = values;
        createOperand();
    }

    /**
     * 피연산자 생성
     */
    private void createOperand() {
        int length = values.length;
        for (int i = 0; i < length; i += 2) {
            addOperand(parseInt(values[i]));
        }
    }

    /**
     * operands add
     */
    private void addOperand(int value) {
        operands.add(value);
    }

    /**
     * parseInt
     */
    private int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("사칙 연산자가 아닙니다.");
        }
    }

    public List<Integer> getOperands() {
        return operands;
    }
}
