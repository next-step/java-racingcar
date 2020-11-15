package race.logic;

import java.util.Optional;

public class RaceGame {
    private final Cars cars;
    private final int numberIterations;
    private ResultEmitter resultEmitter;

    public RaceGame(Cars cars, int numberIterations, ResultEmitter resultEmitter) {
        this.cars = cars;
        this.numberIterations = numberIterations;
        this.resultEmitter = resultEmitter;
    }

    public void play() {
        LapScores latestScore = null;
        for(int i = 0; i < numberIterations; ++i) {
            latestScore = cars.lap();
            resultEmitter.emitScores(latestScore);
        }
        Optional.ofNullable(latestScore)
                .ifPresent(resultEmitter::emitWinner);
    }
}
