package step3;

import java.util.Scanner;

public class RacingCarApplication {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
        int car = InputView.setCarCount();
        int move = InputView.setMoveCount();

        racingCar.run(car, move);

        SCANNER.close();
    }
}
