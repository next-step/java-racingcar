package step3;

import java.util.Scanner;

public class RacingCarApplication {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        CarService carService = new CarService();
        int car = InputView.inputCarCount();
        int move = InputView.inputMoveCount();

        carService.run(car, move);

        SCANNER.close();
    }
}
