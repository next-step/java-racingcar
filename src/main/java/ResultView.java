public class ResultView {

    public static void printCarRacingResult(CarRacingExecutor carRacingExecutor) {
        for (Car car : carRacingExecutor.carList) {
            for (int i = 0; i < car.getCurrentPosition() + 1; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
