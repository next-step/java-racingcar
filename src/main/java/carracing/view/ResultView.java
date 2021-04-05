package carracing.view;

import carracing.domain.Cars;

public class ResultView {

    public static void print(Cars cars, int turn) {
        System.out.println(turn + " 회차");
        System.out.println(cars.toString());
        System.out.println();
    }

    public static void printWinner(Cars cars) {
        System.out.println("=============");
        System.out.println("Winner: " + cars.getWinners());
        System.out.println("=============");
    }
}
