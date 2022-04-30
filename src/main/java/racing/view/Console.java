package racing.view;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Scanner;

public class Console {
    private static Scanner scanner;

    private Console() {
    }

    public static String readLine() {
        return getInstance().nextLine();
    }

    public static int readInteger() {
        return getInstance().nextInt();
    }

    public static Scanner getInstance() {
        if (Objects.isNull(scanner)) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

}
