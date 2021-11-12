package study.car.race;

public class InputView {

    private static final String QUETION_ABOUT_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String QUETION_ABOUT_TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    private InputView() {
    }

    public static int acceptCarCount() {
        System.out.println(QUETION_ABOUT_CAR_COUNT);
        return ScannerUtils.nextInt();
    }

    public static int acceptTryCount() {
        System.out.println(QUETION_ABOUT_TRY_COUNT);
        return ScannerUtils.nextInt();
    }
}
