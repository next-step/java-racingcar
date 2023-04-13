package step3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racer {
    private static final Random random = new Random();
    private final List<Integer> scores;
    private final List<String> results;

    public Racer(int iterations) {
        this.scores = IntStream.rangeClosed(1, iterations).boxed().map(integer -> randomScore()).collect(Collectors.toList());
        this.results = resultCalculate();
    }

    public List<String> resultCalculate() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < this.scores.size(); i++) {
            String currnetRet = resultCalculate(i);
            result.add(currnetRet);
        }
        return result;
    }

    private String resultCalculate(int roundCount) {
        int length = 0;
        for (int j = 0; j < roundCount; j++) {
            if (scores.get(j) > 4) {
                length++;
            }
        }
        return lengthToString(length);
    }

    private String lengthToString(int length) {
        String start = "";
        for (int i = 0; i < length; i++) {
            start += "-";
        }
        return start;
    }

    public List<String> getResults() {
        return results;
    }

    private Integer randomScore() {
        return random.nextInt(9);
    }
}
