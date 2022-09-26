public class ResultView {

    public static void printCarRacingResult(CarRacing carRacing) {
        System.out.println("실행 결과");

        do {
            for (Car car : carRacing.carList) {
                printCarPosition(car);
            }
            System.out.println();
            carRacing.moveAllCar();
        } while (carRacing.remainMoveCount > 0);
    }

    private static void printCarPosition(Car car) {
        for (int i = 0; i < car.getCurrentPosition() + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
