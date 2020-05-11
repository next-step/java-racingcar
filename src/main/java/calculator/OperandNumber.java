package calculator;

public class OperandNumber {

    private final Double value;

    public OperandNumber(String number){
        this.value = Double.parseDouble(number);
    }

    public OperandNumber(double number) {
        this.value = number;
    }

    double doubleValue(){
        return value;
    }
}
