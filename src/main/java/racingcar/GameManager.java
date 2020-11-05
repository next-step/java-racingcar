package racingcar;

public class GameManager {

    private final RuleStrategy ruleStrategy;

    public GameManager(RuleStrategy ruleStrategy) {
        this.ruleStrategy = ruleStrategy;
    }

    public Records play(int carNum, int gameRoundNum) {
        Cars cars = readyCars(carNum);
        GameRounds gameRounds = new GameRounds(gameRoundNum);

        while (!gameRounds.isGameEnd()) {
            cars.move();
            gameRounds.endRound();
            gameRounds.keepRecord(cars);
        }

        return gameRounds.getRecords();
    }

    private Cars readyCars(int carNum) {
        return new Cars(carNum, ruleStrategy);
    }
}
