package step3;

import step3.domain.RacingGame;
import step3.view.InputView;
import step3.view.ResultView;

import static step3.util.StringUtil.splited;

public class Runner {

    public static void main(String[] args) {
        String[] nameOfCars = splited(InputView.nameOfCars());
        int numberOfTry = InputView.numberOfTry();

        RacingGame game = new RacingGame(CarGenerator.generate(nameOfCars), numberOfTry);

        ResultView.printResultInfoMessage();
        for (int round = 0; round < game.totalRound() ; round++) {
            game.playRound();
            ResultView.printRoundResult(game.cars());
        }
        ResultView.printWinner(game.winners());
    }

}
