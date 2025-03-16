package step4;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int rounds;
    private final StringBuilder raceProgress;

    public RacingGame(Cars cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
        this.raceProgress = new StringBuilder();
    }

    public void startGame() {
        for (int round = 0; round < rounds; round++) {
            playRound();
        }
    }

    private void playRound() {
        cars.moveAll();
        raceProgress.append(cars.getCurrentStatus())
                .append("\n");
    }

    public String getRaceProgress() {
        return raceProgress.toString();
    }
    public List<String> winners() {
        return cars.getWinners();
    }
}
