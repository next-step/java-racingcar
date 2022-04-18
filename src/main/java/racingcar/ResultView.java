package racingcar;

public class ResultView {

    public static void showResult(RacingCar[] racingCars) {
        for (RacingCar racingCar : racingCars) {
            showLocation(racingCar);
        }
        System.out.printf("\n");
    }

    public static void showLocation(RacingCar racingCar) {
        for (int i = 0; i < racingCar.getLocation().getX() + 1; i++) {
            System.out.printf("-");
        }
        System.out.printf("\n");
    }
}
