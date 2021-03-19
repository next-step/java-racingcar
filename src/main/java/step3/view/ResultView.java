package step3.view;

import step3.controller.RacingGame;

public class ResultView {
    public static void printRaceResult(RacingGame race) {
        System.out.println("실행결과");
        for (int i = 0; i < race.getNumberOfCars(); i++) {
            System.out.println(race.getCars().get(i).getScore());
        }
    }
}
