package fourstep.view;

import fourstep.logic.Car;
import fourstep.logic.Race;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class ResultView {

    public static void printOneRace(ArrayList<Car> carList, int round) {
        for (Car car : carList) {
            System.out.print(car.getName());
            System.out.print(" : ");
            printCarLocation(car.getRoundRecord(round));
        }
        System.out.println();
    }

    public static void printEntireRace(Race race) {
        ArrayList<Car> carList = race.getCars();
        int raceCount = race.getRaceCount();

        for (int i = 0; i < raceCount; i++) {
            printOneRace(carList, i);
        }
    }

    private static void printCarLocation(int carLocation) {
        IntStream.range(0, carLocation).mapToObj(i -> "-").forEach(System.out::print);
        System.out.println();
    }

    public static void printResultLine() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printWinner(ArrayList<String> winners) {
        String str = String.join(",", winners);
        System.out.print(str);
        System.out.println("가 최종 우승했습니다.");
    }
}
