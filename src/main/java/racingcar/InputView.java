package racingcar;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getTryNumber() {
        System.out.println("How many tries?");
        int number = scanner.nextInt();
        if (!isInputRange(number)) throw new RuntimeException("outOfRange");
        return number;
    }

    public static String[] getCarNames() {
        System.out.println("Put car names to race(separated by ',')");
        String input = scanner.nextLine();
        return parseInput(input);
    }


    public static boolean isInputRange(int i) {
        return 0 < i && i < 10;
    }

    public static String[] parseInput(String s) {
        return s.split("\\s*,\\s*");
    }
}
