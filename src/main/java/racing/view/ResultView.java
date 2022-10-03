package racing.view;

import racing.model.Car;
import racing.model.RaceResult;

import java.util.ArrayList;
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

    private static void printSkidMark(Car car) {
        String skidMark = car.getName() + " : ";
        for (int i = 0; i < car.getPosition(); i++) {
            skidMark += car.getTireMark();
        }
        System.out.println(skidMark);
    }

    public static void printWinner(String winnersName) {
        System.out.println(winnersName + "가 최종 우승했습니다.");
    }

    public static void printResult(RaceResult raceResult) {
        List<String> record = raceResult.getRecord();
        printResultTitle();

        for(String lap: record){
            printRace(lap);
        }
        printWinner(raceResult.getWinnerName());
    }
}
