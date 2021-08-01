package step3;

public class OutputView {

    private static final String ACTION_RESULT = "실행 결과";

    public static void printResult(RacingCars racingCars, boolean isFirstTry) {
        if (isFirstTry) {
            System.out.println(ACTION_RESULT);
        }
        System.out.println(CarsStatusHelper.getCarsStatusView(racingCars));
    }

}
