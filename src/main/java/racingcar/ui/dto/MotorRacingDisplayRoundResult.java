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

    public MotorRacingDisplayRoundResult(List<RacingResult> roundCarRaceResultList) {
        this.roundCarRaceResultList = roundCarRaceResultList;
    }

    private String repate(int raceResult){
        return IntStream.rangeClosed(1,raceResult)
                 .mapToObj(i-> MILEAGE_GAGE)
                 .collect(Collectors.joining(BLANK))
            ;
    }

    @Override
    public String toString() {
        return roundCarRaceResultList.stream()
                                     .map(RacingResult::getTotalMileage)
                                     .map(this::repate)
                                     .collect(Collectors.joining(NEW_LINE))
            ;

    }
}
