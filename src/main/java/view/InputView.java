package view;

import model.PositiveNumber;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String INPUT_CARS_MOVE_COUNT_PRINT = "시도할 횟수는 몇 회 인가요?";
    private final Scanner scanner;


    public static InputView getInstance() {
        return new InputView();
    }

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getInputCarsName() {
        printInputCarsName();
        return scanner.nextLine();
    }

    private void printInputCarsName() {
        System.out.println(INPUT_CARS_NAME);
    }


    public PositiveNumber getInputCarMoveCount() {
        printCarMoveCount();
        return new PositiveNumber(scanner.nextInt());
    }

    private void printCarMoveCount() {
        System.out.println(INPUT_CARS_MOVE_COUNT_PRINT);
    }

}
