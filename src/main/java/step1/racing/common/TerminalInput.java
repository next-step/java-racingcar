package step1.racing.common;

import java.util.Scanner;

public class TerminalInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine(String notice) {
        System.out.print(notice);
        return scanner.nextLine();
    }

    public static int readInt(String notice) {
        System.out.print(notice);
        return scanner.nextInt();
    }
}
