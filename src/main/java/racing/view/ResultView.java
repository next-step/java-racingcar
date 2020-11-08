package racing.view;

import racing.domain.Car;
import racing.domain.CarSetInRace;
import racing.domain.RaceResult;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static racing.domain.CarConfig.*;

public class ResultView {

    private static final String FIRST_EXECUTE_RESULT_MESSAGE = "실행 결과";
    private static final String SKID_MARK = "-";

    private ResultView() {}

    public static void viewRaceResult(RaceResult raceResult) {
        printFirstMessage();

        int maxLaps = raceResult.getMaxLaps();
        for(int i=0; i<maxLaps; i++) {
            int laps = i;
            raceResult.findResult(laps)
                    .forEach(car -> parseRecord(car.getName(),car.getRaceSetting(),laps));
            System.out.print("\n");
        }
    }

    private static void printFirstMessage() {
        System.out.print("\n");
        System.out.printf("%s \n",FIRST_EXECUTE_RESULT_MESSAGE);
        System.out.print("\n");
    }

    private static void parseRecord(String name, CarSetInRace setInRace, int index) {
        String raceRecord = setInRace.findRecord(index);
        raceRecord = Pattern.compile(CAR_RECORD_STRING_SEPARATOR)
                .splitAsStream(raceRecord)
                .filter(str -> !CAR_STOP_MOVE_CODE.contains(str))
                .collect(Collectors.joining());
        System.out.printf("%s : %s \n",
            name,raceRecord.replaceAll(CAR_NORMAL_MOVE_CODE,SKID_MARK)
        );
    }

    public static void viewRaceWinners(RaceResult raceResult) {
        String result = Arrays.toString(raceResult.getWinners())
                .replaceAll("[\\[\\]]","");
        System.out.print(result+"가 최종 우승했습니다.");
    }

}
