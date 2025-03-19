import domain.RacingGame;
import domain.RacingGameResult;
import movingStrategy.RandomlyMove;
import ui.InputView;
import ui.ResultView;

import java.util.Scanner;

public class RacingGameApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);

        String carCountPrompt = "자동차 대수는 몇 대 인가요?";
        String trialCountPrompt = "시도할 회수는 몇 회 인가요?";

        Integer numberOfCar = inputView.queryIntegerInputWithPrompt(carCountPrompt);
        Integer numberOfTrial = inputView.queryIntegerInputWithPrompt(trialCountPrompt);
        RacingGame racingGame = new RacingGame(numberOfCar, numberOfTrial, new RandomlyMove(10, 4));

        new ResultView(System.out).printResult(racingGame.gameStart());
    }
}
