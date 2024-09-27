package car;

public class Car {
    private int position;

    public void move(int number) {
        if (isMove(speedValidationCheck(number))) {
            position++;
        }
    }

    public boolean isMove(int number) {
        return number >= 4;
    }

    public int speedValidationCheck(int number) {
        if (number < 0 || number > 9) throw new RuntimeException("0~9사이의 숫자만 입력해주세요.");
        return number;
    }
}
