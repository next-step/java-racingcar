package step3.model;

import java.util.ArrayList;
import java.util.List;

public class Racer {
    private final String carName;
    private final List<Integer> scores;
    private final List<Integer> positions;
    public Racer(String carName, List<Integer> scores) {
        this.carName = carName;
        this.scores = scores;
        this.positions = calculateResult(scores);
    }

    private List<Integer> calculateResult(List<Integer> scores) {
        List<Integer> result = new ArrayList<>();
        for(int i=0 ; i<scores.size() ; i++) {
            int score = scores.get(i);
            result.add(scoreToResult(score) + prevResult(result, i));
        }
        return result;
    }

    private Integer prevResult(List<Integer> result, int i) {
        return i > 0 ? result.get(i - 1) : 0;
    }

    private Integer scoreToResult(int score) {
        return score >= 4 ? 1 : 0;
    }
}
