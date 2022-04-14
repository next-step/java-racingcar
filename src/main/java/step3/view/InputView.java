package step3.view;

import step3.model.RacingConfig;

import java.util.Scanner;

import static java.lang.System.out;

public class InputView {

    private final Scanner scanner;
    private final RacingConfig racingConfig;

    public InputView() {
        this.scanner = new Scanner(System.in);
        int carCount = askCarCount();
        int tryCount = askTryCount();
        this.racingConfig = new RacingConfig(carCount, tryCount);
        this.scanner.close();
    }

    private int askCarCount() {
        show("자동차 대수는 몇 대 인가요?");
        return saveCount();
    }

    private int askTryCount() {
        show("시도할 회수는 몇 회 인가요?");
        return saveCount();
    }

    private int saveCount() {
        String input = this.scanner.next();
        return Integer.parseInt(input);
    }

    public RacingConfig requestStart() {
        if (this.racingConfig == null) {
            throw new IllegalStateException("시작 전에 설정이 필요합니다.");
        }
        return this.racingConfig;
    }

    private void show(String output) {
        out.println(output);
    }
}
