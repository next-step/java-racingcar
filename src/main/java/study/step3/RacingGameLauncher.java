package study.step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGameLauncher {
    private final static int INIT_ZERO = 0;

    private static List<Round> gameStartAllrounds(RacingGame racingGame, RandomCarMoveCondition moveCondition) {
        List<Round> rounds = new ArrayList<>();
        Round round = new Round(racingGame);
        for (int i = INIT_ZERO; i < racingGame.getTryTime(); i++) {
            if (i == INIT_ZERO){
                rounds.add(round);
                continue;
            }
            round = perRoundGame(round, moveCondition);
            rounds.add(round);
        }
        return rounds;
    }

    private static Round perRoundGame(Round round, RandomCarMoveCondition moveCondition) {
        List<Car> cars = new ArrayList<>();
        for (Car car : round.getCars()){
            cars.add(car.move(moveCondition));
        }
        return new Round(cars);
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.inputTryTime(), InputView.inputCarNumber());

        List<Round> rounds = gameStartAllrounds(racingGame, new RandomCarMoveCondition());

        ResultView resultView = new ResultView(rounds);
        resultView.print();
    }
}
