package racing;

import java.util.List;
import java.util.Map;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-29 01:51
 */
public class CarRace {

    private static final int RANDOM_INT_VALUE_BOUND = 10;

    public static void start(Map<Integer, List<CarNextStep>> participant) {
        playGame(participant, inputGameRound());
    }

    private static int inputGameRound() {
        RacingGameInputView racingGameInputView = new RacingGameInputView();
        return racingGameInputView.inputNumberGameRound();
    }

    private static void playGame(Map<Integer, List<CarNextStep>> participant, int gameRound) {
        for (int round = 0; round < gameRound; round++) {
            moveCar(participant);
            RacingGameResultView.printResult(participant);
        }
    }

    private static void moveCar(Map<Integer, List<CarNextStep>> participant) {
        participant.values().forEach(steps -> {
            steps.add(CarNextStep.getGoOrStop(RandomValue.getInt(RANDOM_INT_VALUE_BOUND)));
        });
    }
}
