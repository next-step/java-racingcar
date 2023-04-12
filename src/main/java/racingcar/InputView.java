package racingcar;

import java.util.Scanner;

public class InputView {
    public static int registerNumberOfCars()
    {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = scanner.nextInt();

        return numberOfCars;
    }

    public static int registerNumberOfMovements()
    {
        Scanner scanner = new Scanner(System.in);
        int numberOfMovements = scanner.nextInt();

        return numberOfMovements;
    }
}
