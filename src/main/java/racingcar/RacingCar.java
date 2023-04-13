package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carAmount = getCarAmount(scanner);
        int tryAmount = getTryAmount(scanner);
        List<Car> cars = createCar(carAmount);

        Game game = new Game(cars);
        OutputView.printExecutionResult();
        for (int i = 0; i < tryAmount; i++) {
            game.play();
            OutputView.printCarPosition(cars);
        }
    }

    private static int getTryAmount(Scanner scanner) {
        InputView.printTryInputGuideMessage();
        int tryAmount = scanner.nextInt();
        Validator.validateTryAmount(tryAmount);
        return tryAmount;
    }

    private static int getCarAmount(Scanner scanner) {
        InputView.printCarInputGuideMessage();
        int carAmount = scanner.nextInt();
        Validator.validateCarAmount(carAmount);
        return carAmount;
    }

    private static List<Car> createCar(int carAmount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carAmount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
