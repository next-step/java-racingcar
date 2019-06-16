package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.util.AssertUtils;

public class GamePlayer {
    private Game game;
    private MovingStrategy movingStrategy;

    private GamePlayer(Game game, MovingStrategy movingStrategy) {
        AssertUtils.notNull(movingStrategy, "'movingStrategy' must not be null");
        this.game = game;
        this.movingStrategy = movingStrategy;
    }

    public static GamePlayer from(MovingStrategy movingStrategy) {
        return new GamePlayer(null, movingStrategy);
    }

    public void initializeGame(CarNames carNames, int numberOfRounds) {
        game = Game.of(carNames, numberOfRounds);
    }

    public void playAllRounds() {
        this.checkGameInitialized();
        while (!game.hasFinished()) {
            game.playOneRound(movingStrategy);
        }
    }

    public Rounds getGameResult() {
        this.checkGameInitialized();
        return game.getResult();
    }

    private void checkGameInitialized() {
        if (game == null) {
            throw new IllegalStateException("Game is not initialized.");
        }
    }

    // TODO: toString
    // TODO: equal
    // TODO: hashcode
}
