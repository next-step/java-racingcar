package race.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class InputView {
    private static final String MSG_READ_NUMBER_CARS       = "자동차 대수는 몇 대 인가요?";
    private static final String MSG_READ_NUMBER_ITERATIONS = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner;
    private final PrintStream out = System.out;

    public InputView() {
        this(System.in);
    }

    public InputView(InputStream in) {
        scanner = new Scanner(in);
    }

    public int readNumberCars() {
        out.println(MSG_READ_NUMBER_CARS);
        return scanner.nextInt();
    }

    public int readNumberIterations() {
        out.println(MSG_READ_NUMBER_ITERATIONS);
        return scanner.nextInt();
    }
}
