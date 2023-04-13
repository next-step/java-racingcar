package step3.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racer {
    private static final Random random = new Random();
    private static final int MOVE_FORWARD_THRESHOLD = 4;
    private final List<Integer> scores;
    private final List<String> results;

    public Racer(int iterations) {
        if(iterations < 0) {
            throw new RuntimeException("iterations 는 1 이상이어야 합니다");
        }
        this.scores = doRace(iterations);
        this.results = calculateResults(scores);
    }

    private List<Integer> doRace(int iterations) {
        return IntStream.range(0, iterations)
                .boxed().map(integer -> randomScore())
                .collect(Collectors.toList());
    }

    public List<String> calculateResults(List<Integer> scoreList) {
        return IntStream.range(0,scoreList.size())
                .boxed()
                .map(integer -> calculateResult(integer,scoreList))
                .collect(Collectors.toList());
    }

    private String calculateResult(int roundCount, List<Integer> scoreList) {
        int position = 0;
        for (int roundIndex = 0; roundIndex <= roundCount; roundIndex++) {
            if (moveForward(scoreList.get(roundIndex))) {
                position++;
            }
        }
        return lengthToString(position);
    }

    private boolean moveForward(int score) {
        return score >= MOVE_FORWARD_THRESHOLD;
    }

    private String lengthToString(int length) {
        return "-".repeat(length);
    }

    public List<String> getResults() {
        return results;
    }

    private Integer randomScore() {
        return random.nextInt(9);
    }
}
