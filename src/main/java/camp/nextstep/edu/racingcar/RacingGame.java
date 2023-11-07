package camp.nextstep.edu.racingcar;

public class RacingGame {

    private final DriveStrategy driveStrategy;
    private final int carAmount;
    private final int roundAmount;
    private final Cars cars;

    public RacingGame(DriveStrategy driveStrategy, int carAmount, int roundAmount) {
        this.driveStrategy = driveStrategy;
        this.carAmount = carAmount;
        this.roundAmount = roundAmount;
        this.cars = new Cars(driveStrategy, carAmount);
    }

    public RacingGameResult play() {
        RacingGameResult racingGameResult = new RacingGameResult();

        for (int i = 0; i < roundAmount; i++) {
            RoundResult roundResult = cars.drive();
            racingGameResult.report(roundResult);
        }
        return racingGameResult;
    }
}
