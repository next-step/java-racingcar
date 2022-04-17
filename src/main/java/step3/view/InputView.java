package step3.view;

import step3.view.dto.RacingConfigDto;

import java.util.Scanner;

import static java.lang.System.out;

public class InputView {

    private final Scanner scanner;
    private final int carCount;
    private final int tryCount;

    public InputView() {
        this.scanner = new Scanner(System.in);
        this.carCount = askCarCount();
        this.tryCount = askTryCount();
        this.scanner.close();
    }

    private int askCarCount() {
        show("자동차 대수는 몇 대 인가요?");
        return this.scanner.nextInt();
    }

    private int askTryCount() {
        show("시도할 회수는 몇 회 인가요?");
        return this.scanner.nextInt();
    }

    public RacingConfigDto requestStart() {
        return new RacingConfigDto(carCount, tryCount);
    }

    private void show(String output) {
        out.println(output);
    }
}
