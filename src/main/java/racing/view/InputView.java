package racing.view;

import java.util.Scanner;

public class InputView {
    public static final String ASK_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    public static final String ASK_NUMBER_OF_TRYS = "시도할 회수는 몇 회 인가요?";
    private int numCars = 0;
    private int numMoves = 0;

    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ASK_NUMBER_OF_CARS);
        numCars = scanner.nextInt();

        System.out.println(ASK_NUMBER_OF_TRYS);
        numMoves = scanner.nextInt();

        System.out.println();
        scanner.close();
    }

    public int getNumCars() {
        return numCars;
    }

    public int getNumMoves() {
        return numMoves;
    }
}
