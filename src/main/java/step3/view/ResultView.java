package step3.view;

import step3.domain.Cars;
import step3.service.RacingGame;

public class ResultView {

    public static void printRaceResult(RacingGame race, Cars cars) {
        System.out.println("실행결과");
        for (int i = 0; i < cars.getCars().size(); i++) {
            System.out.println(cars.getCars().get(i).getRacingLog());
        }
    }

    @Deprecated
    public static void printByAttemps(RacingGame race) {
        Cars cars = race.initCars();
        for (int i = 0; i < race.getAttemps(); i++) {
            race.doRace(cars);
            printByAttemps(cars);
        }
    }

    @Deprecated
    public static void printByAttemps(Cars cars) {
        for (int i = 0; i < cars.getCars().size(); i++) {
            System.out.println(cars.getCars().get(i).getRacingLog());
        }
        System.out.println();
    }
}
