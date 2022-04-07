package calculator;

public class PositiveNumber {

    private int number;

    public PositiveNumber(int number) {
        if(number < 0){
            throw new RuntimeException("음수는 불가합니다.");
        }
        this.number = number;
    }

    public PositiveNumber(String number) {
        this(Integer.parseInt(number));
    }

    public int getValue() {
        return number;
    }
}
