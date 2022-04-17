package step3.view;

import step3.model.Count;
import step3.view.dto.RacingConfigDto;

import java.util.Scanner;

import static java.lang.System.out;

public class InputView {

    private final Scanner scanner;
    private final Count carCount;
    private final Count tryCount;

    public InputView() {
        this.scanner = new Scanner(System.in);
        this.carCount = askCarCount();
        this.tryCount = askTryCount();
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
        return new Count(this.scanner.nextInt());
    }

    public RacingConfigDto requestStart() {
        if (this.carCount == null || this.tryCount == null) {
            throw new IllegalStateException("시작 전에 설정이 필요합니다.");
        }
        return new RacingConfigDto(carCount.getCount(), tryCount.getCount());
    }

    private void show(String output) {
        out.println(output);
    }
}
