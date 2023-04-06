package view;

import java.util.List;

import domain.RacingCar;

public class OutputView {
    public static void printCarsPositionStatus(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
