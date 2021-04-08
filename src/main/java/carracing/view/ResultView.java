package carracing.view;

import carracing.domain.Car;
import carracing.domain.Cars;

public class ResultView {

    public static void print(Cars cars, int turn) {
        System.out.println(turn + " 회차");
        cars.getCars().stream().forEach(car -> print(car));
        System.out.println();
    }

    private static void print(Car car) {
        System.out.println(car.getName().getName() + " : " + positionToString(car.getPosition()));
    }

    private static String positionToString(int position) {
        String result = "";

        for (int count = 0; count < position ; count++)
            result += "-";

        return result;
    }

    public static void printWinner(Cars cars) {
        System.out.println("=============");
        System.out.println("Winner: " + cars.getWinners());

        System.out.println("=============");
    }
}
