package step3.domain;

import step3.domain.history.GameHistory;
import step3.domain.history.RoundHistory;

import java.util.List;
import java.util.stream.Collectors;

public class GameWinner {
    private static final int LAST_ROUND = 0;

    private Car car;

    private GameWinner() {
    }

    public GameWinner(Car car) {
        this.car = car;
    }

    public String getCarName() {
        return car.getName();
    }

    public static List<GameWinner> getGameWinners(GameHistory gameHistory) {
        RoundHistory lastRound = gameHistory.getBy(LAST_ROUND);
        return lastRound.getCarList().stream()
                .filter(car -> car.getPosition() == lastRound.getMaxPosition())
                .map(GameWinner::new)
                .collect(Collectors.toList());
    }
}
