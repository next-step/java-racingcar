package carracing.model;

import carracing.exception.RacerNameLimitException;

import java.util.ArrayList;
import java.util.List;

public class Racer {
    private static final int SCORE_FORWARD_THRESHOLD = 4;
    private final String name;
    private final List<Integer> records;

    public Racer(String name, List<Integer> scores) {
        this.name = name;
        this.records = calculateRecords(scores);
        validate();
    }

    private void validate() {
        if (this.name.length() > 5) {
            throw new RacerNameLimitException();
        }
    }

    private List<Integer> calculateRecords(List<Integer> scores) {
        List<Integer> records = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            records.add(currentRecord(scores.get(i)) + previousRecord(records, i));
        }
        return records;
    }

    private Integer previousRecord(List<Integer> result, int i) {
        return i > 0 ? result.get(i - 1) : 0;
    }

    private Integer currentRecord(int score) {
        return score > SCORE_FORWARD_THRESHOLD ? 1 : 0;
    }

    public String carName() {
        return name;
    }

    public List<String> recordPresentation() {
        List<String> presentList = new ArrayList<>();
        for (int position : records) {
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
