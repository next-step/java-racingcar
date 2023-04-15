package carracing;

import java.util.Scanner;

public class OutputView {

    public static void print() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static void printNewLine() {
        InputView.input("\n");
        OutputView.print();
    }
}
