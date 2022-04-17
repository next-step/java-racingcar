package view;

import model.PositiveNumber;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CARS_NUMBERS_PRINT = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_CARS_MOVE_COUNT_PRINT = "시도할 횟수는 몇 회 인가요?";
    private final Scanner scanner;


    public static InputView getInstance() {
        return new InputView();
    }

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public PositiveNumber getInputCarsNumber() {
        printInputCarsNumber();
        return new PositiveNumber(scanner.nextInt());
    }

    private void printInputCarsNumber() {
        System.out.println(INPUT_CARS_NUMBERS_PRINT);
    }


    public PositiveNumber getInputCarMoveCount() {
        printCarMoveCount();
        return new PositiveNumber(scanner.nextInt());
    }

    private void printCarMoveCount() {
        System.out.println(INPUT_CARS_MOVE_COUNT_PRINT);
    }

}
