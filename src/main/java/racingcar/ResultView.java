package racingcar;

public class ResultView {
    public static void printResult() {
        for (Car car : RacingGame.cars) {
            for (int i = 0; i < car.getDistance(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
