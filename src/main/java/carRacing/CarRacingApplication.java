package carRacing;

import carRacing.domain.Round;
import carRacing.util.GreaterThenThreeMoveStrategy;
import carRacing.util.MoveStrategy;
import carRacing.util.NumberGenerator;
import carRacing.util.RandomNumberGenerator;

import static carRacing.ui.InputView.inputCarList;
import static carRacing.ui.InputView.inputRound;
import static carRacing.ui.ResultView.*;

public class CarRacingApplication {

    public static final MoveStrategy MOVE_STRATEGY = new GreaterThenThreeMoveStrategy();
    public static final NumberGenerator NUMBER_GENERATOR = new RandomNumberGenerator();

    public static void main(String[] args) {
        String[] nameArray = inputCarList();
        int roundCount = inputRound();

        printTitle();

        Round round = new Round(nameArray, MOVE_STRATEGY);
        startRacing(roundCount, round);

        printWinner(round.callWinners());

    }

    public static void startRacing(int roundCount, Round round) {
        for (int i = 0; i < roundCount; i++) {
            printRoundResult(round.play(NUMBER_GENERATOR));
        }

    }
}
