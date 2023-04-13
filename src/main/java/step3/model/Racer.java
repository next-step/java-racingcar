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
        if(iterations < 0) {
            throw new RuntimeException("iterations 는 1 이상이어야 합니다");
        }
        this.scores = IntStream.rangeClosed(1, iterations).boxed().map(integer -> randomScore()).collect(Collectors.toList());
        this.results = calculateResults(scores);
    }

    public List<String> calculateResults(List<Integer> scoreList) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < scoreList.size(); i++) {
            temp.add(calculateResult(i, scoreList));
        }
        return temp;
    }

    private String calculateResult(int roundCount, List<Integer> scoreList) {
        int position = 0;
        for (int j = 0; j <= roundCount; j++) {
            if (scoreList.get(j) > 4) {
                position++;
            }
        }
        return lengthToString(position);
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
