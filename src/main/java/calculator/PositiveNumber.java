package calculator;

public class PositiveNumber {
    private int number;

    public PositiveNumber(String number) {
        int positiveNumber = Integer.parseInt(number);
        if(positiveNumber < 0){
            throw new RuntimeException("Is not positive number");
        }
        this.number = positiveNumber;
    }

    public int valueOf() {
        return number;
    }
}
