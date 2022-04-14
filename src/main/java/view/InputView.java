package view;

import java.util.Scanner;

public class InputView {
    private final String INPUT_CARS_NUMBERS_PRINT = "자동차 대수는 몇 대 인가요?";
    private final String INPUT_CARS_MOVE_COUNT_PRINT = "시도할 횟수는 몇 회 인가요?";
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getInputCarsNumber() {
        printInputCarsNumber();
        return scanner.nextInt();
    }

    private void printInputCarsNumber() {
        System.out.println(INPUT_CARS_NUMBERS_PRINT);
    }


    public int getInputCarMoveCount() {
        printCarMoveCount();
        return scanner.nextInt();
    }

    private void printCarMoveCount() {
        System.out.println(INPUT_CARS_MOVE_COUNT_PRINT);
    }

}
