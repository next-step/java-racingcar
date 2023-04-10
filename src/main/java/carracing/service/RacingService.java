package carracing.service;

import carracing.domain.Record;
import carracing.domain.Round;
import carracing.domain.Score;
import carracing.repository.RoundRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingService {
    private static final Random random = new Random();

    private static final String INITIAL_RACING_RECODE = "";
    private final RoundRepository roundRepository;

    public RacingService(RoundRepository roundRepository) {
        this.roundRepository = new RoundRepository();
    }

    public Map<Round, Record> recordBoardCalculation(Map<Round, List<Score>> raceResults) {
        Map<Round, Record> recordMap = new HashMap<>();

        for (Round round : this.getRounds()) {
            List<String> recordThisRound = new ArrayList<>();

            for (int carIndex = 0; carIndex < raceResults.get(round).size(); carIndex++) {
                Score scoreCurrentCar = raceResults.get(round).get(carIndex);
                recordThisRound.add(calculateCurrentRecode(recordMap, round, carIndex, scoreCurrentCar));
            }
            Record record = new Record(recordThisRound);
            recordMap.put(round, record);
        }
        return recordMap;
    }

    private String calculateCurrentRecode(Map<Round, Record> recordMap, Round round, int carIndex, Score scoreCurrentCar) {
        return getPreviousProgress(round, carIndex, recordMap) + scoreCurrentCar.toProgress();
    }

    //todo : 입력이 3개인 메서드는 리팩토링 대상이다
    private String getPreviousProgress(Round round, int carIndex, Map<Round, Record> curRecordMap) {
        if (round.isFirstRound()) {
            return INITIAL_RACING_RECODE;
        }
        return curRecordMap.get(round.previousRound()).toList().get(carIndex);
    }

    public List<Round> getRounds() {
        return roundRepository.findAll();
    }



    public List<String> lapSituations(Round round) {
        Record record = this.roundRepository.roundToRecordMap().get(round);
        return record.toList();
    }

    public List<String> getData() {
        return null;
    }

    public void racingStart(int participate, int iterations) {
         IntStream.rangeClosed(1, iterations)
            .boxed()
            .collect(
                Collectors.toMap(Round::new, round -> simulateSingleRoundScores(participate))
            );
    }

    private List<Score> simulateSingleRoundScores(int participate) {
        return IntStream.generate(this::randomScore)
            .limit(participate)
            .boxed()
            .map(Score::new)
            .collect(Collectors.toList());
    }

    public int randomScore() {
        return random.nextInt(9);
    }
}
