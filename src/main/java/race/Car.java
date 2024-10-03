package race;

public class Car {

    public static final String QUESTION = "자동차는 몇 대 입니까?";

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 10;

    private int id;

    public Car(int id) {
        this.id = id;
    }

    public static void validateCarCountRange(int carCount) {
        if (carCount < LOWER_BOUND || carCount > UPPER_BOUND) {
            throw new IllegalArgumentException("자동차 수는 "+ LOWER_BOUND +" ~ "+ UPPER_BOUND +"대 사이로 설정해야 합니다.");
        }
    }
}
