package step5.domain;

import java.util.Scanner;

public class InputUtil {

    public static Scanner scanner =new Scanner(System.in);
    public static String returnString(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public static int returnInteger(String question) {
        System.out.println(question);
        int number = scanner.nextInt();
        return number;
    }
}
