package racingcar.ui.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.domain.RacingResult;

public class MotorRacingDisplayRoundResult {
    public static final String MILEAGE_GAGE = "-";
    public static final String NEW_LINE = "\n";
    public static final String BLANK = "";
    private List<RacingResult> roundCarRaceResultList;
    private static MotorRacingDisplayWinnerResults winnerResults = new MotorRacingDisplayWinnerResults();

    public MotorRacingDisplayRoundResult(List<RacingResult> roundCarRaceResultList) {
        this.roundCarRaceResultList = roundCarRaceResultList;
        roundCarRaceResultList.forEach(winnerResults::accumulateRacingTotalMileage);
    }

    private String repate(int raceResult){
        return IntStream.rangeClosed(1,raceResult)
                 .mapToObj(i-> MILEAGE_GAGE)
                 .collect(Collectors.joining(BLANK))
            ;
    }

    private String displayRacingResult(RacingResult racingResult){
        if(racingResult.isEmptyPrefix()){
            return repate(racingResult.getTotalMileage());
        }
        return String.format("%s : %s", racingResult.getPrefix(), repate(racingResult.getTotalMileage()));
    }

    @Override
    public String toString() {
        return roundCarRaceResultList.stream()
                                     .map(this::displayRacingResult)
                                     .collect(Collectors.joining(NEW_LINE))
            ;
    }

    public static MotorRacingDisplayWinnerResults getWinnerResults() {
        return winnerResults;
    }
}
