package racing;

import java.util.Scanner;

public class RacingGameInputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntegerInput(GameMessage gameMessage) {
        System.out.println(gameMessage.getGameMessage());
        return Integer.parseInt(scanner.nextLine().trim());
    }
    public static int getCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public static int getAttemptCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return Integer.parseInt(scanner.nextLine().trim());
    }
}
