package step4.model;

import step4.generator.RandomGenerator;
import step4.strategy.RacingGameLoseMovementStrategy;
import step4.strategy.RacingGameWinMovementStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static final int MAXIMUM_BOUNDARY = 10;
    public static final int RANDOM_CONDITION = 4;
    private List<Car> playerList;

    public RacingGame(List<String> participants) {
        playerList = new ArrayList<>();
        for (String member : participants) {
            playerList.add(new Car(member));
        }
    }

    public void playGame() {
        for (int loop = 0; loop < playerList.size(); loop++) {
            boolean resultForPlayer = doRaceForIndividual();
            decideMovementStrategy(loop, resultForPlayer);
        }
    }

    private void decideMovementStrategy(int value, boolean resultForPlayer) {
        if (resultForPlayer) {
            playerList.get(value).moveWithStrategy(new RacingGameWinMovementStrategy());
        }
        if (!resultForPlayer) {
            playerList.get(value).moveWithStrategy(new RacingGameLoseMovementStrategy());
        }
    }

    private boolean doRaceForIndividual() {
        if (RandomGenerator.generateValue(MAXIMUM_BOUNDARY) >= RANDOM_CONDITION) {
            return true;
        }
        return false;
    }

    public List<Car> getPlayerList() {
        return playerList;
    }
}
