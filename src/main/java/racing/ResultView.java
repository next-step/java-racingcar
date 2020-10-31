package racing;

public final class ResultView {

    public static final String RACING_RESULT = "실행 결과";

    private ResultView() {}

    public static void viewMessage() {
        System.out.println(RACING_RESULT);
    }

    public static void viewRoundResult(final RacingCars racingCars) {
        for (final Car car : racingCars.getCars()) {
            System.out.println(car.getDisplacement());
        }

        System.out.println();
    }
}
