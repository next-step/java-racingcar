package step3.domain;

import step3.service.HistoryService;

import java.util.List;
import java.util.stream.Collectors;

public class GameWinner {
    private static final int LAST_ROUND = 0;

    private HistoryService historyService;

    private GameWinner() {
    }

    private GameWinner(HistoryService historyService) {
        this.historyService = historyService;
    }

    public static GameWinner of(HistoryService historyService) {
        return new GameWinner(historyService);
    }

    public List<String> getGameWinnersName() {
        RoundHistory lastRound = historyService.getBy(LAST_ROUND);
        return lastRound.getCarList().stream()
                .filter(car -> car.getPosition() == lastRound.getMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
