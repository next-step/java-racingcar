package racing.view;

import java.util.Scanner;

public class InputView {
    private static final String ASK_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String ASK_NUMBER_OF_TRYS = "시도할 회수는 몇 회 인가요?";
    private final Scanner scanner = new Scanner(System.in);

    public int getNumCars() {
        System.out.println(ASK_NUMBER_OF_CARS);
        return scanner.nextInt();
    }

    public int getNumMoves() {
        System.out.println(ASK_NUMBER_OF_TRYS);
        return scanner.nextInt();
    }
}
