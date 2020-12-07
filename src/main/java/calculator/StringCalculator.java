package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String SPLIT_REGEX = " ";
    private static final String MARK_ADD = "+";
    private static final String MARK_SUBTRACTION = "-";
    private static final String MARK_MULTIPLICATION = "*";
    
    private List<String> inputList;
    private int baseValue = 0;
    private int differentValue = 0;
    private String mark;

    public StringCalculator(String input) {
        this.inputList = this.splitInput(input);
    }

    public List<String> getInputList() {
        return inputList;
    }

    public void setInputList(List<String> inputList) {
        this.inputList = inputList;
    }

    public int getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(int baseValue) {
        this.baseValue = baseValue;
    }

    public int getDifferentValue() {
        return differentValue;
    }

    public void setDifferentValue(int differentValue) {
        this.differentValue = differentValue;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    /**
     * 입력 값을 쪼개어 리스트에 담습니다.
     * @param input
     * @return
     */
    public List<String> splitInput(String input) {
        return Arrays.asList(input.split(StringCalculator.SPLIT_REGEX));
    }

    /**
     * 입력 된 문자열 값을 계산합니다.
     * @return
     */
    public int calculate() {
        for (int i = 0 ; i < this.getInputList().size() ; i++) {
            this.saveValueAndMark(this.getInputList().get(i).trim(), i);
            executeCalculate(i);
        }
        return this.getBaseValue();
    }

    /**
     * 숫자 값 혹은 연산기호를 저장합니다.
     * @param input
     * @param index
     */
    public void saveValueAndMark(String input, int index) {
        System.out.println("set value : " + input);
        this.isNotData(input);

        if(this.isCalculateIndex(index)) {
            this.setDifferentValue(Integer.parseInt(input));;
            return;
        }

        if(this.isNumberDataIndex(index)) {
            this.setBaseValue(Integer.parseInt(input));
            return;
        }

        this.mark = input;
    }

    /**
     * 데이터가 null이거나 빈 공백 문자일경우 오류를 발생시킵니다.
     * @param input
     * @throws IllegalArgumentException
     */
    public void isNotData(String input) throws IllegalArgumentException {
        if(input == null && input.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 숫자가 와야하는 인덱스인지 체크
     *  : 짝수 일 때 숫자가 와야한다.
     * @param index 
     * @return
     */
    public boolean isNumberDataIndex(int index) {
        return index % 2 == 0;
    }

    /**
     * 계산해야하는 인덱스인지 체크
     *  : 인덱스가 0이 아니여야함
     *  && this.isNumberDataIndex == true
     * @param index 
     * @return
     */
    public boolean isCalculateIndex(int index) {
        return index != 0 && this.isNumberDataIndex(index);
    }

    /**
     * 계산해야하는 인덱스이면 모인 값으로 계산합니다.
     * @param i
     */
    private void executeCalculate(int i) {
        if (this.isCalculateIndex(i)) {
            System.out.printf("f:%s, b:%s, m:%s\n" ,this.baseValue, this.differentValue, this.mark);
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
    public int selectAndExecuteCalculation(int a, int b, String mark) {
        if(StringCalculator.MARK_ADD.equals(mark)) {
            return this.add(a, b);
        }

        if(StringCalculator.MARK_SUBTRACTION.equals(mark)) {
            return this.subtraction(a, b);
        }

        if(StringCalculator.MARK_MULTIPLICATION.equals(mark)) {
            return this.multiplication(a, b);
        }

        throw new IllegalArgumentException("입력값의 기호가 사칙연산 기호가 아닙니다.");
    }

    /**
     * 두 수를 더합니다.
     * @param a
     * @param b
     * @return a + b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * 두 수를 뺍니다
     * @param a
     * @param b
     * @return a - b
     */
    public int subtraction(int a, int b) {
        return a - b;
    }

    /**
     * 두 수를 곱합니다
     * @param a
     * @param b
     * @return a - b
     */
    public int multiplication(int a, int b) {
        return a * b;
    }

}