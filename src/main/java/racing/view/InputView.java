package racing.view;

import java.util.Scanner;

public class InputView {
    public static void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numCars = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numMoves = scanner.nextInt();
        scanner.close();
    }
}
