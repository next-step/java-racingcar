package step3.view;

import step3.view.dto.RacingConfigDto;

import java.util.Scanner;

import static java.lang.System.out;

public class InputView {

    private final Scanner scanner;
    private final String carsName;
    private final int tryCount;

    public InputView() {
        this.scanner = new Scanner(System.in);
        this.carsName = askCarsName();
        this.tryCount = askTryCount();
        this.scanner.close();
    }

    private String askCarsName() {
        show("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return this.scanner.next();
    }

    private int askTryCount() {
        show("시도할 회수는 몇 회 인가요?");
        return this.scanner.nextInt();
    }

    public RacingConfigDto requestStart() {
        return new RacingConfigDto(carsName, tryCount);
    }

    private void show(String output) {
        out.println(output);
    }
}
