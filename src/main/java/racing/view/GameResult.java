package racing.view;

import racing.domain.Game;
import racing.domain.GameRound;

public class GameResult {
    private final static String WHEEL_MARK = "-";
    private final static String GAME_RESULT = "게임 결과";

    private final Game game;

    public GameResult(Game game) {
        this.game = game;
    }

    public void result() {
        roundResult();
    }

    private void roundResult() {
        racing.domain.GameResult gameResult = game.getGameResult();

        System.out.println(GAME_RESULT);
        for (GameRound round : gameResult.getGameRoundList()) {
            positionOfCarPerRound(round);
        }
    }

    private void positionOfCarPerRound(GameRound round) {
        for (Integer positionOfCar : round.getRoundResults()) {
            System.out.println(parsePositionOfCar(positionOfCar));
        }
        System.out.println();
    }

    private String parsePositionOfCar(int forwardCount) {
        return WHEEL_MARK.repeat(forwardCount);
    }
}