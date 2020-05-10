package calculator;

public class OperandNumber {

    private final Double value;

    public OperandNumber(String number){
        this.value = Double.parseDouble(number);
    }

    public OperandNumber(double number) {
        this.value =number;
    }

    OperandNumber plus(OperandNumber operandNumber){
       return new OperandNumber(this.value + operandNumber.value);
    }

    OperandNumber minus(OperandNumber operandNumber){
        return new OperandNumber(this.value - operandNumber.value);
    }

    OperandNumber multiple(OperandNumber operandNumber){
        return new OperandNumber(this.value * operandNumber.value);
    }

    OperandNumber divide(OperandNumber operandNumber){
        return new OperandNumber(this.value / operandNumber.value);
    }

    double doubleValue(){
        return value;
    }
}
