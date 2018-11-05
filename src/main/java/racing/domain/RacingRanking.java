package racing.domain;

import java.util.Comparator;

public class RacingRanking {
    private RacingGame racingGame = null;

    public RacingRanking(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public String[] getWinners() {
        validateGameOver();
        int racingMaxScore = getRacingMaxScore();
        return getWinners(racingMaxScore);
    }

    private String[] getWinners(int racingMaxScore) {
        return racingGame.getResultOfTheGame().stream()
                .filter(car -> car.isPosition(racingMaxScore))
                .map(car -> car.getName())
                .toArray(String[]::new);
    }

    private int getRacingMaxScore() {
        return racingGame.getResultOfTheGame().stream()
                    .max(Comparator.comparing(RacingCar::getCurrentPosition))
                    .map(car -> car.getCurrentPosition())
                    .get();
    }

    private void validateGameOver() {
        if (!racingGame.isFinish()) {
            throw new RacingGameException("RacingGame's still playing.");
        }
    }
}
