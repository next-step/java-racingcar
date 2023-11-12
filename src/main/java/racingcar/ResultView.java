package racingcar;

public class ResultView {
    private static String START_MESSAGE = "실행 결과";

    public static void printResult(RacingGame game) {
        startPrint(game);

        for (RacingCar car : game.getCars()) {
            printLocationOfCar(car);
        }
        System.out.println();
    }

    private static void startPrint(RacingGame game) {
        if (game.checkFirstRound()) {
            System.out.println();
            System.out.println(START_MESSAGE);
        }
    }

    private static void printLocationOfCar(RacingCar car) {
        for (int i = 0; i<car.getLocation(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
