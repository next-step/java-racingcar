package racing.view;

import racing.message.GameMessage;

import java.util.List;
import java.util.Scanner;

public class RacingGameInputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntegerInput(GameMessage gameMessage) {
        System.out.println(gameMessage.getGameMessage());
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public static List<String> getCarNamesInput(GameMessage gameMessage) {
        System.out.println(gameMessage.getGameMessage());
        return List.of(scanner.nextLine().split(","));
    }
}
