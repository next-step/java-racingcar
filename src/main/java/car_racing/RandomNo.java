package car_racing;

public class RandomNo {

    private static final int CAR_MOVE_BOUND = 4;

    private final int number;

    public RandomNo(int number) {
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException("유효한 값이 아닙니다.");
        }
        this.number = number;
    }

    public boolean canMove() {
        return number > CAR_MOVE_BOUND;
    }

}
