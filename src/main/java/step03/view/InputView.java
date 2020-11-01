package step03.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NUMBER_OF_CARS_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String NUMBER_OF_MOVES_QUESTION = "시도할 회수는 몇 회 인가요?";

    public static int scanNumberOfCars() {
        System.out.println(NUMBER_OF_CARS_QUESTION);
        return scanner.nextInt();
    }

    public static int scanNumberOfMoves() {
        System.out.println(NUMBER_OF_MOVES_QUESTION);
        return scanner.nextInt();
    }
}
