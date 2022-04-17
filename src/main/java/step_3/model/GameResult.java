package step_3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResult {

    private final List<List<String>> gameResult;

    public GameResult() {
        this.gameResult = new ArrayList<>();
    }

    public List<List<String>> getGameResult() {
        return this.gameResult;
    }

    public void record(RoundResult roundResult) {
        this.gameResult.add(new ArrayList<>(roundResult.getRoundResult().values()));

        if (gameResult.size() > 1) {
            int beforeLastIndex = this.gameResult.size() - 2;
            int afterLastIndex = this.gameResult.size() - 1;
            List<String> beforeLast = this.gameResult.get(beforeLastIndex);
            List<String> afterLast = this.gameResult.get(afterLastIndex);

            List<String> updateAfterLast = IntStream.range(0, beforeLast.size())
                    .mapToObj(racingCarCount -> beforeLast.get(racingCarCount) + afterLast.get(racingCarCount))
                    .collect(Collectors.toList());

            gameResult.set(afterLastIndex, updateAfterLast);
        }
    }

    public void record(GameResult gameResult) {
        int minIndex = Math.min(this.gameResult.size(), gameResult.getGameResult().size());
        int maxIndex = Math.max(this.gameResult.size(), gameResult.getGameResult().size());

        IntStream.range(minIndex, maxIndex)
                .forEach(index -> this.gameResult.add(gameResult.getGameResult().get(index)));
    }
}
