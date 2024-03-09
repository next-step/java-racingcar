package racingcar.step3;

public class Car {

    private int location;

    public void decideAction(int sign) {
        if (isMoveSign(sign)) {
            move();
        }
    }

    public String getCurrentLocation() {
        return "-".repeat(this.location);
    }

    private boolean isMoveSign(int sign) {
        validateSign(sign);

        return 4 <= sign;
    }

    private void validateSign(int sign) {
        if (sign < 0 || 9 < sign) {
            throw new IllegalArgumentException("유효한 Sign Input이 아닙니다.");
        }
    }

    private void move() {
        location++;
    }
}
