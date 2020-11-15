package race.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String MSG_READ_CAR_NAMES         = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MSG_READ_NUMBER_ITERATIONS = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner;
    private final PrintStream out = System.out;

    public InputView() {
        this(System.in);
    }

    public InputView(InputStream in) {
        scanner = new Scanner(in);
    }

    public List<String> readCarNames() {
        out.println(MSG_READ_CAR_NAMES);
        return Arrays.stream(scanner.nextLine().trim().split("\\s*,\\s*"))
                .collect(Collectors.toUnmodifiableList());
    }

    public int readNumberIterations() {
        out.println(MSG_READ_NUMBER_ITERATIONS);
        return scanner.nextInt();
    }
}
