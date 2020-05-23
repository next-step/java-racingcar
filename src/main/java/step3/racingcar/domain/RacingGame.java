package step3.racingcar.domain;

import step3.racingcar.view.ResultView;

public class RacingGame {

    private String[] carNames;
    private int gameTryCounts;
    private CarGroups playerCars;
    private static final String BLANK_NAME = "";
    private static final int MINIMUM_LIMIT = 1;
    private static final int INDEX_ZERO = 0;

    public RacingGame(String[] carNames, int gameTryCounts) {
        validateConstructors(carNames, gameTryCounts);
        this.carNames = carNames;
        this.gameTryCounts = gameTryCounts;
        this.playerCars = new CarGroups(CarFactory.makeCars(this.carNames));
    }

    private void validateConstructors(String[] carNames, int gameTryCounts) {
        if (carNames.length < MINIMUM_LIMIT || carNames[INDEX_ZERO].equals(BLANK_NAME))
            throw new IllegalArgumentException(Message.ERROR_CAR_NAMES);
        if (gameTryCounts < MINIMUM_LIMIT)
            throw new IllegalArgumentException(Message.ERROR_GAME_TRY_COUNTS);
    }

    public CarGroups run() {
        playerCars.move();
        this.gameTryCounts--;
        return this.playerCars;
    }

    public boolean hasNextRound() {
        return this.gameTryCounts >= MINIMUM_LIMIT;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getGameTryCounts() {
        return gameTryCounts;
    }
}
