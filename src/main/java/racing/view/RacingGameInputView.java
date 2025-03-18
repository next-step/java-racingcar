package racing.view;

import racing.entity.Car;
import racing.generator.CarsGenerator;
import racing.message.GameMessage;

import java.util.List;
import java.util.Scanner;

public class RacingGameInputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_NAME_LENGTH = 5;

    public static List<Car> getCarsInput(GameMessage gameMessage) {
        System.out.println(gameMessage.getGameMessage());

        List<String> carNames = List.of(scanner.nextLine().split(","));
        return CarsGenerator.generateCarList(carNames);
    }

    public static int getRoundCountInput(GameMessage gameMessage) {
        System.out.println(gameMessage.getGameMessage());
        return Integer.parseInt(scanner.nextLine().trim());
    }

}
