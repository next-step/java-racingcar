package race;

import java.util.Random;
import java.util.Scanner;

public class Util {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static int inputCar() {
        return scanner.nextInt();
    }

    public static int inputTry() {
        return scanner.nextInt();
    }

    public static int getRandomNumber() {
        return random.nextInt(10);
    }
}
