package cargameracing;

import java.util.ArrayList;
import java.util.List;

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
        System.out.print(car.getName() + " : ");
        for (int j = 0; j < junjinCount; j++) {
            System.out.print("-");
        }
    }

    public static void displayWinner(Car[] cars) {
        List<String> winner = new ArrayList<String>();
        winner = compareCars(cars);
        for (int i = 0; i < winner.size(); i++) {
            if (i != winner.size() - 1) {
                System.out.print(winner.get(i) + ", ");
            }
            if (i == winner.size() - 1) {
                System.out.print(winner.get(i));
            }
        }
        System.out.print("가 최종 우승했습니다.");
    }

    private static List<String> compareCars(Car[] cars) {
        int max = cars[0].getJunjin();
        List<String> result = new ArrayList<String>();
        result.add(cars[0].getName());
        for (int i = 1; i < cars.length; i++) {
            if(max == cars[i].getJunjin()) {
                result.add(cars[i].getName());
            }
            if(max < cars[i].getJunjin()) {
                result.remove(result.size() - 1);
                result.add(cars[i].getName());
            }
        }
        return result;
    }
}
