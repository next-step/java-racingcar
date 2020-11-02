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
        return getCountFromInput("자동차 대수는 몇 대 인가요?");
    }

    public Integer getTryCountFromInput() {
        return getCountFromInput("시도할 회수는 몇 회 인가요?");
    }

    private Integer getCountFromInput(String message) {
        output.println(message);
        Integer count = scanner.nextInt();
        validateCount(count);
        return count;
    }

    private void validateCount(Integer count) {
        if (count <= 0) {
            throw new IllegalArgumentException("invalid count");
        }
    }
}
