package carracing.domain;

import carracing.repository.RoundRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

import static carracing.RaceApplication.getIoc;

public class Round implements Comparable<Round> {
    private static final int FIRST_ROUND_VALUE = 1;
    private static final AtomicInteger INDEX = new AtomicInteger(FIRST_ROUND_VALUE);
    public static final List<Score> emptyScores = new ArrayList<>();
    private static final IntUnaryOperator validate = value -> {
        if (value < FIRST_ROUND_VALUE) {
            return value;
        }
        throw new RuntimeException("라운드는 1부터 시작하므로 항상 1 이상입니다");
    };
    private Integer roundId;
    private List<Score> scores;
    private List<Record> records;

    public Round(List<Score> scoreList) {
        this.roundId = INDEX.getAndIncrement();
        this.scores = scoreList;
        this.records = scoreToRecord(scoreList);
    }

    private List<Record> scoreToRecord(List<Score> scoreList) {
        AtomicInteger integer = new AtomicInteger(0);
        List<Record> recordList = new ArrayList<>();
        for(Score score : scoreList) {
            recordList.add(new Record(calRecord(integer, score)));
        }
        return recordList;
    }

    private String calRecord(AtomicInteger integer, Score score) {
        if(isFirstRound() ) {
            return score.toProgress();
        }
        return score.toProgress() + prevScoreProgress(integer.getAndIncrement());
    }

    private String prevScoreProgress(int index) {
        RoundRepository roundRepository = (RoundRepository) getIoc().get(RoundRepository.class);
        Round byId = roundRepository.findById(this.getRoundId()-  1);
        return byId.getRecords().get(index).getRecord();
    }

    public boolean isFirstRound() {
        return this.roundId <= FIRST_ROUND_VALUE;
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

    public int getRoundId() {
        return roundId;
    }

    public List<Score> getScores() {
        return scores;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRoundId(int i) {
        this.roundId = i;
    }
}
