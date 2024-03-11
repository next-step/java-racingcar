package step3_racing_car;

import java.util.List;
import java.util.Scanner;

public class OutputView {
    public static void printRoundResult(RacingCars racingCars) {
        System.out.println("실행결과");
        for (int i = 0; i < racingCars.getRacingCars().size(); i++) {
            int position = racingCars.getRacingCars().get(i).getPosition();
            String name = racingCars.getRacingCars().get(i).getName();
            System.out.println(name + " : " + "-".repeat(position));
        }
    }

    public static void printGameWinner(RacingCars racingCars) {
        System.out.println();
        for (int i = 0; i < racingCars.getRacingCars().size() - 1; i++) {
            String name = racingCars.getRacingCars().get(i).getName();
            System.out.print(name + ",");
        }
        System.out.println(racingCars.getRacingCars().get(racingCars.getRacingCars().size() - 1));
    }
}
