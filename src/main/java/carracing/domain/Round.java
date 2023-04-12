package carracing.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Round implements Comparable<Round> {
    private final List<Score> scores;
    private final List<Record> records;
    private Integer roundId;

    public Round(List<Score> scores, List<Record> records) {
        this.scores = scores;
        this.records = records;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }

    public List<Score> getScores() {
        return scores.stream()
            .map(score -> new Score(score.getValue()))
            .collect(Collectors.toList());
    }

    public List<Record> getRecords() {
        return records.stream()
            .map(record -> new Record(record.getRecord()))
            .collect(Collectors.toList());
    }

    @Override
    public int compareTo(Round other) {
        return Integer.compare(this.getRoundId(), other.getRoundId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return roundId == round.roundId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundId);
    }

}
