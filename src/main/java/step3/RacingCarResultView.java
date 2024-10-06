package step3;

public class RacingCarResultView {

    static void printRacingCarStatus(RacingCar racingCar) {

        for (int i = 0; i < racingCar.getNumberOfCar(); i++) {
            for (int j = 0; j < racingCar.getCarPosition(i); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

}
