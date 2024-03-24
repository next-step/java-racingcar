package racinggame.domain;

public class CarRandomNo {
    private static final int FORWARD_NUM = 4;

    private final int number;

    public CarRandomNo(int number) {
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException("값이 유효하지 않습니다.");
        }
        this.number = number;
    }

    public boolean movable() {
        return this.number >= FORWARD_NUM;
    }
}
