package racingcar;

public class CarStatus {

    private static final int INIT_GRADE = 0;
    private static final int MOVE_GRADE = 1;

    private final int grade;

    private CarStatus(int grade) {
        this.grade = grade;
    }

    public int grade() {
        return grade;
    }

    public static CarStatus init() {
        return new CarStatus(INIT_GRADE);
    }

    public CarStatus moveForward() {
        return new CarStatus(grade + MOVE_GRADE);
    }
}
