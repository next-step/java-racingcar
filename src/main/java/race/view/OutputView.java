package race.view;

import race.domain.Cars;

import java.util.ArrayList;

public class OutputView {

    public static void printCarMileage(int numberOfCars, int count) {
        for (int j = 0; j < numberOfCars; j++) {
            System.out.println(new Cars(new ArrayList<>(), numberOfCars).getCarList().get(j).go(count));
        }
    }

    public static void printResultComment() {
        System.out.println("\n실행 결과");
    }

    public static void printRacingRound() {
        System.out.println("\n");
    }

}
