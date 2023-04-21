package racingcar.view;

import java.util.Scanner;

public class InputView {
    public static String inputNameOfCars()
    {
        Scanner scanner = new Scanner(System.in);
        String nameOfCars = scanner.next();

        return nameOfCars;
    }

    public static int inputNumberOfMovements()
    {
        Scanner scanner = new Scanner(System.in);
        int numberOfMovements = scanner.nextInt();

        return numberOfMovements;
    }
}
