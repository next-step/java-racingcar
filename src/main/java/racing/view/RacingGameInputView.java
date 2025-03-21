package racing.view;

import racing.domain.Car;
import racing.domain.RacingCars;
import racing.generator.CarListGenerator;
import racing.view.message.GameMessage;

import java.util.List;
import java.util.Scanner;

public class RacingGameInputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static RacingCars getCarsInput() {
        System.out.println(GameMessage.CAR_NAME_INPUT_MESSAGE.getGameMessage());

        List<String> carNames = List.of(scanner.nextLine().split(","));
        List<Car> carList = CarListGenerator.generateCarList(carNames);

        return new RacingCars(carList);
    }

    public static int getRoundCountInput() {
        System.out.println(GameMessage.ROUND_COUNT_INPUT_MESSAGE.getGameMessage());
        return Integer.parseInt(scanner.nextLine().trim());
    }

}
