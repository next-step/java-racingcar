package racing.car.car;

public class Car implements Movable {
    private int position;

    public void move(int number) {
        if (isMoveAllowed(validateSpeed(number))) {
            position++;
        }
    }

    private boolean isMoveAllowed(int number) {
        return number >= 4;
    }

    private int validateSpeed(int number) {
        if (number < 0 || number > 9) throw new RuntimeException("0~9사이의 숫자만 입력해주세요.");
        return number;
    }
}
