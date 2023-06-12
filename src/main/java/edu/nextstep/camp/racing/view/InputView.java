package edu.nextstep.camp.racing.view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner;

    public static String input() {
        if (Objects.isNull(scanner)){
            scanner = new Scanner(System.in);
        }

        return scanner.nextLine();
    }

    public static void close() {
        if (!Objects.isNull(scanner)){
            scanner.close();
            scanner = null;
        }
    }
}
