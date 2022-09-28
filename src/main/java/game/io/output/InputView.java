package game.io.output;

public class InputView {

    private final static String INPUT_CAR_NUMBER_GUIDE = "자동차 대수는 몇 대 인가요?";
    private final static String INPUT_CAR_NAME_GUIDE = "자동차 대수는 몇 대 인가요?";

    private final static String INPUT_ROUND_GUIDE = "시도할 회수는 몇 회 인가요?";

    public static void printInputCarGuide() {
        System.out.println(INPUT_CAR_NUMBER_GUIDE);
    }

    public static void printInputNameGuide() {
        System.out.println(INPUT_CAR_NAME_GUIDE);
    }

    public static void printInputRoundGuide() {
        System.out.println(INPUT_ROUND_GUIDE);
    }
}
