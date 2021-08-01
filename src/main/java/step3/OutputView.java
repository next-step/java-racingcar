package step3;

public class OutputView {

    private static final String ACTION_RESULT = "실행 결과";

    public static void printResult(RacingCars racingCars, int tries) {
        System.out.println(ACTION_RESULT);
        printStatus(racingCars, tries);
    }

    private static void printStatus(RacingCars racingCars, int tries) {
        System.out.println(racingCars.getStatus());
        for (int i = 0; i < tries - 1; i++) {
            racingCars.run();
            System.out.println(racingCars.getStatus());
        }
    }

}
