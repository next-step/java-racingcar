package racing.view;

import racing.domain.Car;
import racing.domain.RaceResult;

import java.util.List;

public class ResultView {
    private ResultView() {

    }

    public static void printResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printRace(String record) {
        System.out.println(record);
    }

    public static void printWinner(String winnersName) {
        System.out.println(winnersName + "가 최종 우승했습니다.");
    }

    public static void printResult(RaceResult raceResult) {
        List<String> record = raceResult.getRecord();
        printResultTitle();

        for (String lap : record) {
            printRace(lap);
        }
        printWinner(join(raceResult.getWinnersName()));
    }

    public static String join(List<String> names) {
        return String.join(",", names);
    }
}
