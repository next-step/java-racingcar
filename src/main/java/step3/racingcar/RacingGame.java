package step3.racingcar;

import java.util.List;

public class RacingGame {

    private String[] carNames;
    private int gameTryCounts;
    private static final String BLANK_NAME = "";
    private static final int MINIMUM_GAME_TRY_COUNTS = 1;
    private static final int INDEX_ZERO = 0;

    public RacingGame(String[] carNames, int gameTryCounts) {
        validateConstructors(carNames, gameTryCounts);
        this.carNames = carNames;
        this.gameTryCounts = gameTryCounts;
    }

    private void validateConstructors(String[] carNames, int gameTryCounts) {
        if (carNames[INDEX_ZERO].equals(BLANK_NAME))
            throw new IllegalArgumentException();
        if (gameTryCounts < MINIMUM_GAME_TRY_COUNTS)
            throw new IllegalArgumentException();
    }

    public void run() {
        //List<Car> cars = CarFactory.makeCars(this.carCounts);
        //startRacing(cars);
    }

    private void startRacing(List<Car> cars) {
        ResultViewProcessor.printResultHeader(Message.RESULT_HEADER);
        for (int i = 0; i < gameTryCounts; i++) {
            cars.forEach(Car::move);
            ResultViewProcessor.printResult(cars);
        }
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getGameTryCounts() {
        return gameTryCounts;
    }
}
