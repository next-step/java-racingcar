package racing;

import java.util.List;

public class ResultView {
    private static final char PRINT_ONGOING_CHAR = '-';

    public void printStartMessage() {
        System.out.println("실행 결과");
    }

    public void printCarListStatus(List<RacingCar> carList) {
        for (RacingCar racingCar : carList) {
            printCarStatus(racingCar);
        }
        System.out.println();
    }

    public void printCarStatus(RacingCar car) {
        int count = car.getNumberOfOngoing();
        printOngoingStatus(count);
    }

    private void printOngoingStatus(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(PRINT_ONGOING_CHAR);
        }
        System.out.println();
    }
}
