package calculator;

public class Number {
    private final String number;

    public Number(String number) {
        if (number == null || number.isBlank()) {
            number = "0";
        }
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
