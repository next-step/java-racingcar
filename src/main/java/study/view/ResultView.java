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
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void printCarNameAndRacingResult(List<Car> raceList) {
        for (Car car : raceList) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void printWinnerCar(List<Car> winnerList) {
        Iterator<Car> winners = winnerList.iterator();
        while (winners.hasNext()) {
            Car winner = winners.next();
            System.out.print(winner.getName());
            if (winners.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println(" 가 최종 우승했습니다.");
    }
}
