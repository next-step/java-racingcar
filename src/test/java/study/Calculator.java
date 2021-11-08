package study;

public class Calculator {
    private String operator;
    private int firstValue;
    private int secondValue;

    public int calculate(String input) {
        this.parse(input);

        if("+".equals(this.operator)) {
            return this.firstValue + this.secondValue;
        }

        if("-".equals(this.operator)) {
            return this.firstValue - this.secondValue;
        }

        if("*".equals(this.operator)) {
            return this.firstValue * this.secondValue;
        }

        if("/".equals(this.operator)) {
            return this.firstValue / this.secondValue;
        }

        return 0;
    }

    private void parse(String input) {
        isValidInput(input);

        String[] splitInput = input.split(" ");

        this.operator = splitInput[1];
        isValidOperator();

        this.firstValue = Integer.parseInt(splitInput[0]);
        this.secondValue = Integer.parseInt(splitInput[2]);
    }

    private void isValidOperator() {
        if(!"+".equals(this.operator) && !"-".equals(this.operator) && !"*".equals(this.operator) && !"/".equals(this.operator)) {
            throw new IllegalArgumentException("사칙 연산 기호가 아닙니다.");
        }
    }

    private void isValidInput(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다.");
        }
    }
}
