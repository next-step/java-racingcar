package racing.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public int numberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;
    }

    public int moveCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;
    }
}
