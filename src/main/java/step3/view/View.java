package step3.view;

import step3.model.Count;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class View {

    private static final String DISPLAY_CHARACTER = "ㅋ";

    private final Scanner scanner;
    private final RacingConfig racingConfig;

    public View() {
        this.scanner = new Scanner(System.in);
        Count carCount = askCarCount();
        Count tryCount = askTryCount();
        this.racingConfig = new RacingConfig(carCount, tryCount);
        this.scanner.close();
    }

    private Count askCarCount() {
        show("자동차 대수는 몇 대 인가요?");
        return saveCount();
    }

    private Count askTryCount() {
        show("시도할 회수는 몇 회 인가요?");
        return saveCount();
    }

    private Count saveCount() {
        String input = this.scanner.next();
        int count = Integer.parseInt(input);
        return new Count(count);
    }

    public RacingConfig requestStart() {
        if (this.racingConfig == null) {
            throw new IllegalStateException("시작 전에 설정이 필요합니다.");
        }
        return this.racingConfig;
    }

    public void printResult(List<Integer> result) {
        String displayResult = result.stream()
                .map(DISPLAY_CHARACTER::repeat)
                .collect(Collectors.joining("\n"));
        show(displayResult);
    }

    private void show(String output) {
        out.println(output);
    }
}
