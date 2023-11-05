import game.Car;
import game.RacingGame;
import ui.RacingGameRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int theNumberOfCars = question("자동차 대수는 몇 대 인가요?");
        int theNumberOfCycles = question("시도할 회수는 몇 회 인가요?");

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < theNumberOfCars; i++) {
            carList.add(new Car(1));
        }

        RacingGame racingGame = new RacingGame(carList);

        System.out.println("실행 결과");

        RacingGameRenderer.renderGame(racingGame);

        for (int cycle = 1; cycle < theNumberOfCycles; cycle++) {
            racingGame.doACycle();
            System.out.println("");
            RacingGameRenderer.renderGame(racingGame);
        }
    }

    private static int question(String questionMessage) {
        System.out.print(questionMessage + ": ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }
}
