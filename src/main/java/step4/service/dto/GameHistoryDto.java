package step4.service.dto;

import step4.domain.GameHistory;

import java.util.List;
import java.util.stream.Collectors;

public class GameHistoryDto {
    private final List<CarsDto> history;
    private final Winners winners;

    private GameHistoryDto(List<CarsDto> history, Winners winners) {
        this.history = history;
        this.winners = winners;
    }

    public static GameHistoryDto of(GameHistory gameHistory) {
        List<CarsDto> carsDtoList = gameHistory.getHistory().stream().map(CarsDto::of)
                .collect(Collectors.toList());
        Winners winners = Winners.create(gameHistory.getWinnerNames());
        return new GameHistoryDto(carsDtoList, winners);
    }

    public List<CarsDto> getHistory() {
        return history;
    }

    public Winners getWinners() {
        return winners;
    }
}
