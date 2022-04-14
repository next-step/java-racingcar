package racingcar.view;

import racingcar.racing.RacingCar;

import java.util.List;

public class ResultView {

    private static final String DASH = "-";
    private static final String EMPTY = "";
    private static final StringBuilder strBuilder = new StringBuilder("\n\n실행 결과\n");

    public static void show(List<RacingCar> racingCarList) {
        printHead();

        printBody(racingCarList);
    }

    private static void printHead() {
        System.out.print(strBuilder.toString());
    }

    private static void printBody(List<RacingCar> racingCarList) {
        for (RacingCar car : racingCarList) {
            printDash(car);
        }
    }


    private static void printDash(RacingCar racingCar) {
        for (int i = 0; i < racingCar.getProgress(); i++) {
            System.out.print(DASH);
        }

        System.out.println(EMPTY);
    }
}
