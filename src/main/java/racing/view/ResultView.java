package racing.view;

import racing.domain.CarSetInRace;
import racing.domain.RaceResult;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static racing.domain.CarConfig.*;

public class ResultView {

    private static final String FIRST_EXECUTE_RESULT_MESSAGE = "실행 결과";
    private static final String SKID_MARK = "-";

    private final RaceResult raceResult;

    public ResultView(RaceResult raceResult) {
        this.raceResult = raceResult;
    }

    public void viewRaceResult() {
        printFirstMessage();

        int maxLaps = raceResult.getMaxLaps();
        for(int i=0; i<maxLaps; i++) {
            int laps = i;
            raceResult.findResult(laps)
                    .forEach(car -> parseRecord(car.getRaceSetting(),laps));
            System.out.print("\n");
        }
    }

    public void printFirstMessage() {
        System.out.print("\n");
        System.out.printf("%s \n",FIRST_EXECUTE_RESULT_MESSAGE);
        System.out.print("\n");
    }

    private void parseRecord(CarSetInRace setInRace,int index) {
        String raceRecord = setInRace.findRecord(index);
        raceRecord = Pattern.compile(CAR_RECORD_STRING_SEPARATOR)
                .splitAsStream(raceRecord)
                .filter(str -> !CAR_STOP_MOVE_CODE.contains(str))
                .collect(Collectors.joining());
        System.out.println(raceRecord.replaceAll(CAR_NORMAL_MOVE_CODE,SKID_MARK));
    }

}
