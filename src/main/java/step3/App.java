package step3;

import step3.model.CarGroup;
import step3.view.InputView;

import java.util.Scanner;

public class App {
    public static final int CRITERION_NUMBER = 4;
    public static final int RANGE = 9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputView.viewCarCount();
        int carCount = scanner.nextInt();
        InputView.viewCount();
        int count = scanner.nextInt();

        Game game = new Game(count);
        game.run(new CarGroup(carCount));
    }
}
