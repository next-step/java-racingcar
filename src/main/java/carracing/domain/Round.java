package carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.IntUnaryOperator;

public class Round implements Comparable<Round> {
    private static final int FIRST_ROUND_VALUE = 1;
    public static final List<Score> emptyScores = new ArrayList<>();
    private static final IntUnaryOperator validate = value -> {
        if (value < FIRST_ROUND_VALUE) {
            return value;
        }
        throw new RuntimeException("라운드는 1부터 시작하므로 항상 1 이상입니다");
    };
    private int id;
    private List<Score> scores;
    private List<Record> records;

    public Round(List<Score> scoreList) {
        this.scores = scoreList;
        this.records = scoreToRecord(scoreList);
    }

    private List<Record> scoreToRecord(List<Score> scoreList) {
        List<Record> recordList = new ArrayList<>();
        for(Score score : scoreList) {
            recordList.add(new Record(score.toProgress() + score.prevScoreProgress()));
        }
        return recordList;
    }

    public boolean isFirstRound() {
        return this.id == FIRST_ROUND_VALUE;
    }


    @Override
    public int compareTo(Round other) {
        return Integer.compare(this.getId(), other.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return id == round.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public List<Score> getScores() {
        return scores;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setId(int i) {
        this.id = i;
    }
}
