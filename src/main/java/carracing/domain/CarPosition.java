package carracing.domain;

/**
 * 자동차의 위치를 저장하는 클래스
 */
public class CarPosition {
    private static final int INITIATION_POSITION_NUMBER = 0;

    private int number;

    public CarPosition() {
        this.number = INITIATION_POSITION_NUMBER;
    }

    CarPosition(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (isNegativeNumber(number)) {
            throw new IllegalArgumentException("자동차의 위치는 0또는 양의 정수가 입력되어야합니다.");
        }
    }

    private boolean isNegativeNumber(int number) {
        return number < 0;
    }

    public boolean isSameWith(int number) {
        return this.number == number;
    }

    public void move() {
        this.number++;
    }

    public int getNumber() {
        return number;
    }
}
