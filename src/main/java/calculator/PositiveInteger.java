package calculator;

public class PositiveInteger {

    private int number;

    PositiveInteger(String number){
        this(Integer.parseInt(number));
    }

    PositiveInteger(int number){
        if(number < 0) {
            throw new RuntimeException("음수는 허용하지 않습니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
