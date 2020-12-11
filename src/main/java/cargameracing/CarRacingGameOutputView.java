package cargameracing;

/**
 * View Role
 * @author minji
 */
public class CarRacingGameOutputView {

    public static void displayResult(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            gameResult(cars[i]);
            System.out.println();
        }
    }

    public static void gameResult(Car car) {
        int junjinCount = car.getJunjin();
        for (int j = 0; j < junjinCount; j++) {
            System.out.print("-");
        }
    }
}
