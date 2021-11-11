package racinggame.view;

import racinggame.domain.Laps;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public Integer inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public Laps inputLaps() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return new Laps(scanner.nextInt());
    }
}
