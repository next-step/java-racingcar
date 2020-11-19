package racing.domain;

public class RacingGame {

    private final int roundCount;
    private final Cars cars;
    private final RacingRound racingRound;

    public RacingGame(int roundCount, String[] names) {
        this.roundCount = roundCount;
        this.cars = new Cars(names);
        this.racingRound = new RacingRound();
    }

    public RacingRound startRacing() {
        for (int i = 0; i < roundCount; i++) {
            racingRound.addRacingResult(cars.go());
        }

        return racingRound;
    }
}
