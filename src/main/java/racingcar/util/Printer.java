package racingcar.util;

import static java.lang.System.out;

public final class Printer {
    private Printer() {}

    public static void display(String message){
        out.println(message);
    }
}
