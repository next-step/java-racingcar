package step3.racingcar.domain;

public class RacingGame {

    private int gameTryCounts;
    private final CarGroups playerCars;
    private static final String BLANK_NAME = "";
    private static final int MINIMUM_LIMIT = 1;
    private static final int INDEX_ZERO = 0;

    public RacingGame(String[] carNames, int gameTryCounts) {
        validateConstructors(carNames, gameTryCounts);
        this.gameTryCounts = gameTryCounts;
        this.playerCars = new CarGroups(CarFactory.makeCars(carNames));
    }

    private void validateConstructors(String[] carNames, int gameTryCounts) {
        if (carNames.length < MINIMUM_LIMIT || carNames[INDEX_ZERO].equals(BLANK_NAME))
            throw new IllegalArgumentException(Message.ERROR_CAR_NAMES);
        if (gameTryCounts < MINIMUM_LIMIT)
            throw new IllegalArgumentException(Message.ERROR_GAME_TRY_COUNTS);
    }

    public void run() {
        playerCars.move();
        gameTryCounts--;
    }

    public boolean hasNextRound() {
        return gameTryCounts >= MINIMUM_LIMIT;
    }

    public int getGameTryCounts() {
        return gameTryCounts;
    }

    public CarGroups getPlayerCars() { return playerCars; }
}
