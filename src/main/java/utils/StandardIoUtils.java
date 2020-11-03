package utils;

import java.util.Scanner;

public class StandardIoUtils {

    private StandardIoUtils() {
    }

    public static String input(String label) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println(label);
            return in.nextLine();
        }
    }
}
