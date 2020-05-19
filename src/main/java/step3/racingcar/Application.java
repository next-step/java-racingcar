package step3.racingcar;

public class Application {

    public static void main(String[] args) {
        String[] carNames = InputViewProcessor.getCarNames(Message.CAR_NAMES);
        int gameTryCounts = InputViewProcessor.getGameTryCounts(Message.GAME_TRY_COUNTS);

        RacingGame racingGame = new RacingGame(carNames, gameTryCounts);
    }
}
