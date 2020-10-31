package step3;

public class Car {
    private Integer position;

    public Car() {
        position = 0;
    }

    public boolean move(Integer luckyNumber) {
        validateLuckyNumber(luckyNumber);
        if (canMove(luckyNumber)) {
            increasePosition();
            return true;
        }
        return false;
    }

    private void validateLuckyNumber(Integer luckyNumber) {
        if (luckyNumber < 0 || luckyNumber > 9) {
            throw new IllegalArgumentException("invalid luck for car");
        }
    }

    private boolean canMove(Integer luckyNumber) {
        return luckyNumber >= 4;
    }

    private void increasePosition() {
        position += 1;
    }

    public Integer getPosition() {
        return position;
    }
}
