import domain.RacingGame;
import movingStrategy.RandomlyMove;
import ui.InputView;

import java.util.Scanner;

public class RacingGameApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);

        Integer numberOfCar = inputView.queryIntegerInputWithPrompt("자동차 대수는 몇 대 인가요?\n");
        Integer numberOfTrial = inputView.queryIntegerInputWithPrompt("시도할 회수는 몇 회 인가요?\n");
        RacingGame racingGame = new RacingGame(numberOfCar, numberOfTrial, new RandomlyMove(10, 4));
    }
}
