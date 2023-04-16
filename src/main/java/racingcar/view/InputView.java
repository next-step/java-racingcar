package racingcar.view;

import java.util.Scanner;

public class InputView {
    public static int inputNumberOfCars()
    {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = scanner.nextInt();

        return numberOfCars;
    }

    public static int inputNumberOfMovements()
    {
        Scanner scanner = new Scanner(System.in);
        int numberOfMovements = scanner.nextInt();

        return numberOfMovements;
    }
}
