package race.Utils;

public class InputUtils {
    public static final String INPUT_NUMBER_OF_CAR = "자동차 대수는 몇 대 인가요?";
    public static final String INPUT_NUMBER_OF_MOVEMENT = "시도할 회수는 몇 회 인가요?";

    private InputUtils() {
        throw new AssertionError("생성자 호출 금지");
    }

    public static void inputCarView() {
        System.out.println(INPUT_NUMBER_OF_CAR);
    }

    public static void inputMoveView() {
        System.out.println(INPUT_NUMBER_OF_MOVEMENT);
    }
}
