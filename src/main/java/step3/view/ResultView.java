package step3.view;

import step3.domain.Cars;
import step3.service.RacingGame;

public class ResultView {
    public static void printByAttemps(RacingGame race) {
        Cars cars = new Cars(race.setCars());
        for (int i = 0; i < race.getAttemps(); i++) {
            race.start(cars);
            startToPrint(i);
            printByAttemps(cars);
        }
    }

    public static void startToPrint(int iter) {
        if (iter == 0) {
            System.out.println("실행 결과");
        }
    }

    public static void printByAttemps(Cars cars) {
        for (int i = 0; i < cars.getCars().size(); i++) {
            System.out.println(cars.getCars().get(i).getRacingLog());
        }
        System.out.println();
    }
}
