package racing.view;

import racing.RacingCars;

public class ResultView {
    public static void resultMessage() {
        System.out.println("실행 결과");
    }

    public static void printPosition(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void resultGame(RacingCars racingCars) {
        for (int i = 0; i < racingCars.getCars().size(); i++) {
            printPosition(racingCars.getCars().get(i).getPosition());
        }
        System.out.println();
    }
}