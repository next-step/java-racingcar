package racing_game.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResult {

    private final List<Map<String, String>> gameResult;

    public GameResult() {
        this.gameResult = new ArrayList<>();
    }

    public List<Map<String, String>> getGameResult() {
        return this.gameResult;
    }

    public void record(RoundResult roundResult) {
        this.gameResult.add(roundResult.getRoundResult());

        if (gameResult.size() > 1) {
            this.update();
        }
    }

    public void record(GameResult gameResult) {
        int minIndex = Math.min(this.gameResult.size(), gameResult.getGameResult().size());
        int maxIndex = Math.max(this.gameResult.size(), gameResult.getGameResult().size());

        if (gameResult.getGameResult().size() > this.gameResult.size()) {
            IntStream.range(minIndex, maxIndex)
                    .forEach(index -> this.gameResult.add(gameResult.getGameResult().get(index)));
        }
    }

    private void update() {
        int beforeLastIndex = this.gameResult.size() - 2;
        int afterLastIndex = this.gameResult.size() - 1;
        Map<String, String> beforeLast = this.gameResult.get(beforeLastIndex);
        Map<String, String> afterLast = this.gameResult.get(afterLastIndex);

        Map<String, String> update = afterLast
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> beforeLast.get(entry.getKey()) + entry.getValue(), (l, r) -> l, LinkedHashMap::new));
        gameResult.set(afterLastIndex, update);
    }
}
