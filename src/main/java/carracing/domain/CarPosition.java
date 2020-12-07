package carracing.domain;

/**
 * 자동차의 위치를 저장하는 클래스
 */
public class CarPosition {
    private int number;

    CarPosition(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (isNegativeNumber(number)) {
            throw new IllegalArgumentException("자동차의 위치는 0또는 양의 정수가 입력되어야합니다.");
        }
    }

    private boolean isNegativeNumber(int position) {
        return position < 0;
    }

    public void move() {
        this.number++;
    }

    public int getNumber() {
        return number;
    }
}
