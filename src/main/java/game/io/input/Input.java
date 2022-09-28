package game.io.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    public static int inputPositiveNumber() {
        try (Scanner sc = new Scanner(System.in)) {
            int result = sc.nextInt();
            checkPositiveNumber(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static List<String> inputNames() {
        try (Scanner sc = new Scanner(System.in)) {
            return names(sc.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static List<String> names(String text) {
        List<String> result = new ArrayList<>();
        for (String name : text.split(",")) {
            result.add(name);
        }
        return result;
    }

    private static void checkPositiveNumber(int result) {
        if (result < 0) {
            throw new RuntimeException();
        }
    }
}
