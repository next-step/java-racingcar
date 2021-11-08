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
        String[] splitInput = input.split(" ");

        this.operator = splitInput[1];
        this.firstValue = Integer.parseInt(splitInput[0]);
        this.secondValue = Integer.parseInt(splitInput[2]);
    }
}
