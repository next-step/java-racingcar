package step3;

public class Car {

    private static final int MOVABLE_POWER = 4;
    private static final int[] RANGE_OF_ACCELERATOR = {0, 9};

    private int position;

    public Car() {
    }

    public int getCurrentPosition() {
        return this.position;
    }

    public void moveForward(int power) {
        if(isOutOfRange(power)) {
            throw new IllegalArgumentException("엑셀의 작동 범위를 벗어납니다.");
        }

        if (power >= MOVABLE_POWER) {
            this.position++;
        }
    }

    private boolean isOutOfRange(int power) {
        return power < RANGE_OF_ACCELERATOR[0] || power > RANGE_OF_ACCELERATOR[1];
    }
}
