package carracing.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class InputView {

    public static final String PARTICIPAT = "자동차 대수는 몇 대 인가요?";
    public static final String ITERATIONS = "시도할 회수는 몇 회 인가요?";
    private final Scanner scanner;
    private final PrintStream printStream;

    public InputView(InputStream inputStream, PrintStream printStream) {
        this.scanner = new Scanner(inputStream);
        this.printStream = printStream;
    }

    public int participates() {
        printStream.println(PARTICIPAT);
        return scanner.nextInt();
    }

    public int iterations() {
        System.out.println(ITERATIONS);
        return scanner.nextInt();
    }
}
