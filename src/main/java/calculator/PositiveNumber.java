package calculator;

public class PositiveNumber {
    private int number;

    public PositiveNumber(String number) {
        if(number == null || number.isBlank() || !number.matches("^([-]?[0-9]*)$")) {
            throw new RuntimeException("Is not number");
        }
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
