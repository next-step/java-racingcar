package study.view;

import study.domain.Car;

import java.util.Iterator;
import java.util.List;

public class ResultView {

    private ResultView() { //인스턴스화 방지
    }

    public static void beforeRacingPrintMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printOneRacingResult(List<Car> raceList) {
        for (Car car : raceList) {
            visualizeCarPosition(car);
        }
        System.out.println("");
    }

    public static void printCarNamesAndResults(List<Car> raceList) {
        for (Car car : raceList) {
            System.out.print(car.getName() + " : ");
            visualizeCarPosition(car);
        }
        System.out.println("");
    }

    private static void visualizeCarPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    public static void printFinalWinnerNames(List<Car> winnerList) {
        Iterator<Car> winners = winnerList.iterator();

        while (winners.hasNext()) {
            printWinnerName(winners);
        }

        System.out.println(" 가 최종 우승했습니다.");
    }

    private static void printWinnerName(Iterator<Car> winners) {
        System.out.print(winners.next().getName());

        if (winners.hasNext()) {
            System.out.print(", ");
        }
    }
}
