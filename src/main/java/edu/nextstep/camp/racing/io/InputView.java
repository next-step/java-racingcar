package edu.nextstep.camp.racing.io;

import java.lang.reflect.Field;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner;

    private static boolean isClosed;

    private InputView() {
    }

    public static Scanner getInstance() {
        if (scanner == null  || isClosed) {
            scanner = new Scanner(System.in);
            isClosed = false;
        }
        return scanner;
    }

    public static String input() {
        return getInstance().nextLine();
    }

    public static synchronized void close() {
        if (scanner != null) {
            scanner.close();
            isClosed = true;
        }
    }
}
