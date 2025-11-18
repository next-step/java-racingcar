package racingcar;

import java.util.Scanner;

public class InputView {
    static int readCount(String x, Scanner scanner) {
        System.out.println(x);
        return scanner.nextInt();
    }

    static String readNames(String x, Scanner scanner) {
        System.out.println(x);
        return scanner.nextLine();
    }

    static void addCar(String name) {
        String[] split = name.split(",");
        for (String carName : split) {
            new Car(carName);
        }
    }
}
