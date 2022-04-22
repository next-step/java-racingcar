package view;

import model.MoveCount;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String INPUT_CARS_MOVE_COUNT_PRINT = "시도할 횟수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);


    public static String getInputCarsName() {
        printInputCarsName();
        return scanner.nextLine();
    }

    private static void printInputCarsName() {
        System.out.println(INPUT_CARS_NAME);
    }


    public static MoveCount getInputCarMoveCount() {
        printCarMoveCount();
        return new MoveCount(scanner.nextInt());
    }

    private static void printCarMoveCount() {
        System.out.println(INPUT_CARS_MOVE_COUNT_PRINT);
    }

}
