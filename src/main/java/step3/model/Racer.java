package step3.model;

import java.util.ArrayList;
import java.util.List;

public class Racer {
    private final String name;
    private final List<Integer> records;
    public Racer(String name, List<Integer> scores) {
        this.name = name;
        this.records = calculateRecords(scores);
    }

    private List<Integer> calculateRecords(List<Integer> scores) {
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

    public String carName() {
        return name;
    }

    public List<String> positionPresentation() {
        List<String> presentList = new ArrayList<>();
        for(int position : records) {
            presentList.add("-".repeat(position));
        }
        return presentList;
    }

    public int finalPosition() {
        return records.get(records.size() - 1);
    }

    public boolean isWinner(int winnerPosition) {
        return this.finalPosition() == winnerPosition;
    }
}
