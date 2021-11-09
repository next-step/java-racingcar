package step4;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameHistory {
    private final Map<Integer, Cars> history = new HashMap<>();
    private Winners winners;

    public void save(Integer now, Cars tempHistory) {
        history.put(now, tempHistory);
    }

    public Cars getHistory(Integer time) {
        Cars log = history.get(time);
        if (log == null) {
            throw new IllegalArgumentException("history가 존재하지 않습니다.");
        }
        return log;
    }

    public void saveWinner(Winners winners) {
        this.winners = winners;
    }

    public Winners getWinners() {
        return winners;
    }

    public String toStringGameHistory(Integer time) {
        String result = IntStream.range(0, time)
                .mapToObj(now -> history.get(now).toStringCars())
                .collect(Collectors.joining("\n\n"));
        return result + "\n\n" + winners.toString() + "가 최종 우승 했습니다.";
    }
}
