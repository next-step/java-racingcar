package step3;

import java.util.Scanner;

public class InputView {

    public InputView() {}

    public InputDto getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int car = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int trial = scanner.nextInt();

        return new InputDto(car, trial);
    }
}
