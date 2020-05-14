package calculator;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StringCalculatorEntity {

    private List<String> operands;
    private List<String> operators;

    public StringCalculatorEntity() {
        operands = new ArrayList<>();
        operators = new ArrayList<>();
    }

    public StringCalculatorEntity(String[] totalInputSplitArray) {
        this();
        setLists(totalInputSplitArray);
    }

    public int getOperatorCount() {
        return operators.size();
    }

    public int getOperandItem(int index) {
        return Integer.parseInt(operands.get(index));
    }

    public String getOperatorItem(int index) {
        return operators.get(index);
    }

    /**
     *  StringCalculator에서 받은 수식 array를 연산자와 피연산자로 나눈다.
     * @param array
     */
    private void setLists(String[] array) {
        //StringCalculator에서 최소 갯수를 String의 길이로 비교하였고,
        //split으로 나뉜 array가 홀수인지 비교한다.
        if ((array.length % 2) != 1) {
            throw new IllegalArgumentException("수식을 다시 입렵해주세요.");
        }

        operands.add(array[0]);
        //수식 분리
        for (int i = 1; i < array.length ; i+=2) {
            operators.add(array[i]);
            operands.add(array[i+1]);
        }

        checkOperators();
        checkListsSize();
    }

    /**
     * operands와 operators의 길이로 수식이 제대로 나뉘었는지 확인한다.
     * 3 + 3 / 2 * 2
     * 피연산자 4개 연산자 3개 피연산자가 1개 더 많음.
     */
    private void checkListsSize() {
        if (operands.size() - 1 != operators.size()) {
            throw new IllegalArgumentException("validation 실패! 수식을 다시 입력해주세요");
        }
    }

    /**
     * 연산자를 검증한다.
     */
    private void checkOperators() {
        for (String operator : operators) {
            if (!checkOperator(operator)) {
                throw new IllegalArgumentException("사칙연산이 아닙니다. [" + operator + "]");
            }
        }
    }



    /**
     * 연산자가 4칙연산이 맞는지 확인한다.
     * @param operator 연산자
     * @return boolean 4칙연산 여부
     */
    private boolean checkOperator(String operator) {

        return  "+".equals(operator) ||
                "-".equals(operator) ||
                "*".equals(operator) ||
                "/".equals(operator);
    }
}
