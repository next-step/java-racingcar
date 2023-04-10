package carracing.logic.service;

import carracing.logic.domain.Record;
import carracing.logic.domain.Round;
import carracing.logic.domain.Score;
import carracing.logic.repository.RoundRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingService {
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
}
