package calculator;

public class Positive extends Number {

    public Positive() {
        super();
    }

    public Positive(String number) {
        try {
            int parseNum = Integer.parseInt(number);
            if (parseNum < 0) {
                throw new RuntimeException("음수는 들어올 수 없습니다.");
            }
            changeNumber(parseNum);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 형태가 아닌 값이 존재합니다.");
        }
    }

    public Positive(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 들어올 수 없습니다.");
        }
        changeNumber(number);
    }
}
