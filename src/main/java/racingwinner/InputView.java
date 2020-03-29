package racingwinner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static int rounds;
    private static String[] cars;

    public static String[] cars() {
        return inputCarsValidator();
    }

    public static int rounds() {
        return inputRoundValidator();
    }

    public static String[] inputCarsValidator() {
        String carsName = scanner.nextLine();
        cars = carsName.trim().split(",");
        return cars;
    }

    public static int inputRoundValidator() {
        try {
            rounds = isGreaterThan0(scanner.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력가능합니다.");
            scanner.close();
        }
        return rounds;
    }

    public static int isGreaterThan0(int rounds) {
        if (rounds < 1) {
            System.out.println("1이상의 숫자를 입력해 주세요");
            scanner.close();
        }
        return rounds;
    }

}
