package racing.view;

import java.util.Scanner;

public class InputView {
    private int numCars = 0;
    private int numMoves = 0;

    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        numCars = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        numMoves = scanner.nextInt();
        scanner.close();
    }

    public int getNumCars() {
        return numCars;
    }

    public int getNumMoves() {
        return numMoves;
    }
}
