package carracing.service;

import carracing.domain.Record;
import carracing.domain.Round;
import carracing.domain.Score;
import carracing.repository.RoundRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingService {
    private static final Random random = new Random();
    private final RoundRepository roundRepository;

    public RacingService(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }

    private int randomScore() {
        return random.nextInt(9);
    }

    public void racingStart(int participates, int iterations) {
        IntStream.rangeClosed(1, iterations)
            .boxed()
            .forEach(integer -> roundStart(participates));
    }

    public List<Round> racingResults() {
        return roundRepository.findAll();
    }

    public void roundStart(int participates) {
        List<Score> collect = IntStream.rangeClosed(1, participates)
            .boxed()
            .map(s -> randomScore())
            .map(Score::new)
            .collect(Collectors.toList());
        roundRepository.save(new Round(
            collect, scoreToRecord(collect)
        ));
    }

    private List<Record> scoreToRecord(List<Score> scoreList) {
        AtomicInteger integer = new AtomicInteger(0);
        List<Record> recordList = new ArrayList<>();
        for (Score score : scoreList) {
            recordList.add(new Record(calRecord(integer, score)));
        }
        return recordList;
    }

    private String calRecord(AtomicInteger integer, Score score) {
        if (isFirstRound()) {
            return score.render();
        }
        return score.render() + prevScoreProgress(integer.getAndIncrement());
    }

    private boolean isFirstRound() {
        return roundRepository.count() == 0;
    }

    private String prevScoreProgress(int index) {
        Round byId = roundRepository.findById(roundRepository.count());
        return byId.getRecords().get(index).getRecord();
    }

    public List<Round> findAllRounds() {
        return roundRepository.findAll();
    }

}
