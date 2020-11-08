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
                .forEach(car -> printRecord(car.getName(),car.getRaceSetting(),laps));
            System.out.print("\n");
        }
    }

    public static void viewRaceWinners(RaceResult raceResult) {
        String result = Arrays.toString(raceResult.getWinners())
                .replaceAll("[\\[\\]]","");
        System.out.print(result+" 가 최종 우승했습니다.");
    }

    private static void printFirstMessage() {
        System.out.print("\n");
        System.out.printf("%s \n",FIRST_EXECUTE_RESULT_MESSAGE);
        System.out.print("\n");
    }

    private static void printRecord(String name,CarSetInRace setInRace, int index) {
        System.out.println(parseRecord(name,setInRace,index));
    }

    public static String parseRecord(String name,CarSetInRace setInRace, int index) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(name);
        strBuilder.append(" : ");
        strBuilder.append(makeSkidMark(setInRace.findRecord(index)));
        return strBuilder.toString();
    }

    private static String makeSkidMark(String input) {
        return Pattern.compile(CAR_RECORD_STRING_SEPARATOR)
                .splitAsStream(input)
                .filter(str -> !CAR_STOP_MOVE_CODE.contains(str))
                .collect(Collectors.joining())
                .replaceAll(CAR_NORMAL_MOVE_CODE,SKID_MARK);
    }


}
