package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputView.printCarInputGuideMessage();
        int carAmount = scanner.nextInt();
        InputView.validateCarAmount(carAmount);

        InputView.printTryInputGuideMessage();
        int tryAmount = scanner.nextInt();
        InputView.validateTryAmount(tryAmount);

        List<Car> cars = createCar(carAmount);

        Game game = new Game(cars);
        OutputView.printExecutionResult();
        for (int i = 0; i < tryAmount; i++) {
            game.play();
            OutputView.printCarPosition(game.getCars());
        }
    }

    private static List<Car> createCar(int carAmount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carAmount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
