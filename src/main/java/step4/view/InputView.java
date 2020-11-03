package step4.view;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;
    private final PrintWriter output;

    public InputView(Scanner scanner, PrintWriter output) {
        this.scanner = scanner;
        this.output = output;
    }

    public List<String> getCarNames() {
        output.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> names = Arrays.asList(scanner.next().split(","));
        validateNames(names);
        return names;
    }

    private void validateNames(List<String> names) {
        if (names.size() == 0) {
            throw new IllegalArgumentException("invalid car count");
        }
        if (names.stream().filter(name -> name.length() > 5).count() > 0) {
            throw new IllegalArgumentException("invalid car name length");
        }
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
