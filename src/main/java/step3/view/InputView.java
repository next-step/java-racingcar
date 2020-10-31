package step3.view;

import java.io.PrintWriter;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;
    private final PrintWriter output;

    public InputView(Scanner scanner, PrintWriter output) {
        this.scanner = scanner;
        this.output = output;
    }

    public Integer getCarCountFromInput() {
        output.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public Integer getTryCountFromInput() {
        output.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
