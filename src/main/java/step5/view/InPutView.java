package step5.view;

import java.util.Scanner;

public class InPutView {

    private static final Scanner scanner = new Scanner(System.in);
    public static String name() {
        return scanner.nextLine();
    }

    public static int howManyTimesToTrye() {
        return scanner.nextInt();
    }
}
