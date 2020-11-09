package racing.view;

import racing.domain.RaceRound;
import java.util.Arrays;
import java.util.stream.IntStream;

import static racing.view.ResultViewMessage.*;

public class ResultView {

    private static final String SKID_MARK = "-";

    private ResultView() {}

    public static void viewRaceResult(RaceRound raceRound) {
        printFirstMessage();

        int maxRounds = raceRound.getRoundCount();
        for(int i=0; i<maxRounds; i++) {
            int laps = i;
            raceRound.findResult(laps).getResultCars()
                .forEach(car -> printRecord(car.getName(),car.getDistance()));
            System.out.print("\n");
        }
    }

    public static void viewRaceWinners(RaceRound raceRound) {
        String result = Arrays.toString(raceRound.getWinners())
                .replaceAll("[\\[\\]]","");
        System.out.printf("%s %s",result,LAST_EXECUTE_RESULT_MESSAGE);
    }

    private static void printFirstMessage() {
        System.out.print("\n");
        System.out.printf("%s \n",FIRST_EXECUTE_RESULT_MESSAGE);
        System.out.print("\n");
    }

    private static void printRecord(String name,int position) {
        System.out.printf("%s : %s\n",name,makeSkidMark(position));
    }

    private static String makeSkidMark(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0,position)
                .forEach(i -> stringBuilder.append(SKID_MARK));
        return stringBuilder.toString();
    }


}
