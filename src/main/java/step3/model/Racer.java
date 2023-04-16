package step3.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racer {
    private static final Random random = new Random();
    private static final int MOVE_FORWARD_THRESHOLD = 4;
    private final Score scores;
    private final Result results;
    private final Car car;

    public Racer(int iterations, Car car) {
        validateIterations(iterations);
        this.scores = doRace(iterations);
        this.results = calculateResults(scores.getScoreList());
        this.car = car;
    }

    private void validateIterations(int iterations) {
        if (iterations < 0) {
            throw new RuntimeException("iterations 는 1 이상이어야 합니다");
        }
    }

    private Score doRace(int iterations) {
        return new Score(
            IntStream.range(0, iterations)
                .boxed().map(integer -> randomScore())
                .collect(Collectors.toList())
        );
    }

    public Result calculateResults(List<Integer> scoreList) {
        return new Result(
            IntStream.range(0, scoreList.size())
                .boxed()
                .map(integer -> calculateResult(integer, scoreList))
                .collect(Collectors.toList())
        );
    }

    private String calculateResult(int roundCount, List<Integer> scoreList) {
        return  "-".repeat( getPos(roundCount, scoreList));
    }

    private int getPos(int roundCount, List<Integer> scoreList) {
        return (int) scoreList.stream()
            .limit(roundCount + 1)
            .filter(this::moveForward).count();
    }

    private boolean moveForward(int score) {
        return score >= MOVE_FORWARD_THRESHOLD;
    }

    private String lengthToString(int length) {
        return "-".repeat(length);
    }

    public List<String> getResults() {
        return results.getPositionList();
    }

    private Integer randomScore() {
        return random.nextInt(9);
    }

    public Integer getFinalPosition() {
        return finalRecord().length();
    }

    private String finalRecord() {
        return results.getPositionList()
            .get(results.getPositionList().size() - 1);
    }

    public Car getCar() {
        return this.car;
    }

    public boolean isSamePosition(int position) {
        return position == getFinalPosition();
    }
}
