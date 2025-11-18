package racinggame.view;

import racinggame.domain.Car;

import java.util.Scanner;

public class InputView {
    public static int readCount(String x, Scanner scanner) {
        System.out.println(x);
        return scanner.nextInt();
    }

    public static String readNames(String x, Scanner scanner) {
        System.out.println(x);
        return scanner.nextLine();
    }

    public static void splitCarName(String name) {
        String[] split = name.split(",");

        for (String carName : split) {
            new Car(carName);
        }
    }
}
