package racing.view;

import racing.domain.Car;
import racing.domain.RaceResult;
import racing.domain.RaceRound;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static racing.view.ResultViewMessage.*;

public class ResultView {

    private static final String SKID_MARK = "-";

    private ResultView() {}

    public static void viewRaceResult(RaceRound raceRound) {
        printFirstMessage();
        racePlay(raceRound,raceRound.getRoundCount());
    }

    private static void racePlay(RaceRound raceRound,int maxRounds) {
        IntStream.range(0,maxRounds)
                .forEach(i->raceStart(raceRound,i));
    }

    private static void raceStart(RaceRound raceRound, int index) {
        getResultCars(raceRound,index)
                .forEach(car -> printRecord(car.getName(),car.getDistance()));
        System.out.print("\n");
    }

    private static List<Car> getResultCars(RaceRound raceRound,int index) {
        return getResult(raceRound,index).getResultCars();
    }

    private static RaceResult getResult(RaceRound raceRound, int index) {
        return raceRound.findResult(index);
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
