package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class StringCalculator {
    
    private List<String> inputList;
    private int baseValue = 0;
    private int differentValue = 0;
    private String mark;

    public StringCalculator(List<String> inputList) {
        this.inputList = inputList;
    }


    /**
     * 입력 된 문자열 값을 계산합니다.
     * @return
     */
    public int calculate() throws IllegalArgumentException {
        for (int i = 0 ; i < this.inputList.size() ; i++) {
            this.saveValueAndMark(this.inputList.get(i), i);
            executeCalculate(i);
        }
        return this.baseValue;
    }

    /**
     * 숫자 값 혹은 연산기호를 저장합니다.
     * @param input
     * @param index
     */
    private void saveValueAndMark(String input, int index) throws IllegalArgumentException {
        this.validateEmptyData(input);

        if(this.isCalculateIndex(index)) {
            this.differentValue = Integer.parseInt(input);;
            return;
        }

        if(this.isNumberDataIndex(index)) {
            this.baseValue = Integer.parseInt(input);
            return;
        }

        this.saveCalculateMark(input);
    }

    /**
     * 데이터가 null이거나 빈 공백 문자일경우 오류를 발생시킵니다.
     * @param input
     * @throws IllegalArgumentException
     */
    private void validateEmptyData(String input) {
        if(input == null || input.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 숫자가 와야하는 인덱스인지 체크
     *  : 짝수 일 때 숫자가 와야한다.
     * @param index 
     * @return
     */
    private boolean isNumberDataIndex(int index) {
        return index % 2 == 0;
    }

    /**
     * 계산해야하는 인덱스인지 체크
     *  : 인덱스가 0이 아니여야함
     *  && this.isNumberDataIndex == true
     * @param index 
     * @return
     */
    private boolean isCalculateIndex(int index) {
        return index != 0 && this.isNumberDataIndex(index);
    }

    private boolean isCalculateMark(String input) {
        return Operator.valueOfOperator(input) != null;
    }

    private void saveCalculateMark(String input) throws IllegalArgumentException {
        if(this.isCalculateMark(input)) {
            this.mark = input;
        }
    }

    /**
     * 계산해야하는 인덱스이면 모인 값으로 계산합니다.
     * @param i
     */
    private void executeCalculate(int i) throws IllegalArgumentException {
        if (this.isCalculateIndex(i)) {
            this.baseValue = this.selectAndExecuteCalculation(this.baseValue, this.differentValue, this.mark);
        }
    }

    /**
     * 사칙연산을 선택하여 호출합니다.
     * @param a
     * @param b
     * @param mark
     * @return calculate result
     */
    private int selectAndExecuteCalculation(int a, int b, String mark) throws IllegalArgumentException {
        return Operator.valueOfOperator(mark).calculate(a, b);

    }
}