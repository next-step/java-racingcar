package carracing;

import java.util.Scanner;

public class OutputView {

    public static void print() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}
