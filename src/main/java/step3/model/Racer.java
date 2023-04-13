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
        this.results = makeResultCalculate(scores);
    }

    public List<String> makeResultCalculate(List<Integer> scoreList) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < scoreList.size(); i++) {
            temp.add(stringCurentProgress(i, scoreList));
        }
        return temp;
    }

    private String stringCurentProgress(int roundCount,List<Integer> scoreList) {
        int length = 0;
        for (int j = 0; j < roundCount; j++) {
            if (scoreList.get(j) > 4) {
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
