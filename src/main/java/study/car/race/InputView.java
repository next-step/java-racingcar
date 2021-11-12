package study.car.race;

public class InputView {

    private InputView() {
    }

    public static int acceptCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return ScannerUtils.nextInt();
    }

    public static int acceptTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return ScannerUtils.nextInt();
    }
}
