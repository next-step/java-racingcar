package calculator.domain;

public class Operand {

    private int number;

    public Operand(String number) {
        this.number = toInt(number);
    }

    public Operand(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] " + number + "는 숫자가 아닙니다");
        }
    }
}

