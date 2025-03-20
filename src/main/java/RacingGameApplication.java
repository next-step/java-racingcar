import domain.RacingGame;
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
        int bound = 10;
        int threshold = 4;

        Integer numberOfCar = inputView.queryIntegerInputWithPrompt(carCountPrompt);
        Integer numberOfTrial = inputView.queryIntegerInputWithPrompt(trialCountPrompt);
        RacingGame racingGame = new RacingGame(numberOfCar, numberOfTrial, new RandomlyMove(bound, threshold));

        new ResultView(System.out).printResult(racingGame.gameStart());
    }
}
