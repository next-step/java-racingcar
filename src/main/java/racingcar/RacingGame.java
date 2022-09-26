package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<RacingCar> racingCars;
    private final int gameTurnCount;
    private final List<String> gameLogs;

    public RacingGame(List<RacingCar> racingCars, int gameTurnCount) {
        this.racingCars = racingCars;
        this.gameTurnCount = gameTurnCount;
        this.gameLogs = new ArrayList<>(gameTurnCount);
    }

    public void run() {
        for (int i = 0; i < this.gameTurnCount; i++) {
            this.racingCars.forEach(RacingCar::move);
            log();
        }
    }

    private void log() {
        this.gameLogs.add(this.racingCars.stream()
                                         .map(ResultView::getLocationString)
                                         .collect(Collectors.joining("\n")));
    }

    public List<String> getGameLogs() {
        return gameLogs;
    }
}
