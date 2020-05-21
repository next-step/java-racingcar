package step3.racingcar;

import java.util.List;

public class RacingGame {

    private String[] carNames;
    private int gameTryCounts;
    private static final String BLANK_NAME = "";
    private static final int MINIMUM_LIMIT = 1;
    private static final int INDEX_ZERO = 0;

    public RacingGame(String[] carNames, int gameTryCounts) {
        validateConstructors(carNames, gameTryCounts);
        this.carNames = carNames;
        this.gameTryCounts = gameTryCounts;
    }

    private void validateConstructors(String[] carNames, int gameTryCounts) {
        if (carNames.length < MINIMUM_LIMIT || carNames[INDEX_ZERO].equals(BLANK_NAME))
            throw new IllegalArgumentException(Message.ERROR_CAR_NAMES);
        if (gameTryCounts < MINIMUM_LIMIT)
            throw new IllegalArgumentException(Message.ERROR_GAME_TRY_COUNTS);
    }

    public void run() {
        CarGroups playerCars = new CarGroups(CarFactory.makeCars(this.carNames));
        ResultViewProcessor.printResultHeader(Message.RESULT_HEADER);
        for (int i = INDEX_ZERO; i < gameTryCounts; i++) {
            playerCars.move();
            ResultViewProcessor.printResult(playerCars);
        }
        ResultViewProcessor.printWinnerCarNames(playerCars);
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getGameTryCounts() {
        return gameTryCounts;
    }
}
