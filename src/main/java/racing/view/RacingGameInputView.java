package racing.view;

import racing.entity.Car;
import racing.entity.RacingCars;
import racing.generator.CarsGenerator;
import racing.message.GameMessage;

import java.util.List;
import java.util.Scanner;

public class RacingGameInputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static RacingCars getCarsInput(GameMessage gameMessage) {
        System.out.println(gameMessage.getGameMessage());

        List<String> carNames = List.of(scanner.nextLine().split(","));
        List<Car> carList = CarsGenerator.generateCarList(carNames);

        return new RacingCars(carList);
    }

    public static int getRoundCountInput(GameMessage gameMessage) {
        System.out.println(gameMessage.getGameMessage());
        return Integer.parseInt(scanner.nextLine().trim());
    }

}
