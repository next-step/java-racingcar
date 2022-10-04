package game.view.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    public static Scanner SCANNER = new Scanner(System.in);
    public static String NAME_SEPARATOR = ",";

    public static int inputNumber() {
        try {
            return SCANNER.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static List<String> inputNames() {
        try {
            return names(SCANNER.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static List<String> names(String text) {
        List<String> result = new ArrayList<>();
        for (String name : text.split(NAME_SEPARATOR)) {
            result.add(name);
        }
        return result;
    }
}
