package racingcar.v1.ui;

import racingcar.v1.domain.Car;

import java.util.List;
import java.util.Scanner;

public class View {

    private View() {}

    private static Scanner sc = new Scanner(System.in);

    public static String inputNames() {
        System.out.println("input names : ");
        return sc.next();
    }

    public static int inputRotationCount() {
        System.out.println("rotation count : ");
        int rotation = sc.nextInt();
        sc.nextLine();
        return rotation;
    }

    public static void printRace(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public static void printWinner(List<String> winnerList) {
        System.out.println("final winner : " + winnerList.toString());
    }
}
