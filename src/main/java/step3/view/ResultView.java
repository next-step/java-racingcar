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
}
