package racinggame.view;

import racinggame.domain.Laps;
import racinggame.domain.Names;

import java.util.Scanner;

public class InputView {

    private static String MESSAGE_ENTRY_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static String MESSAGE_TYR_COUNT = "시도할 회수는 몇회인가요?";

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public Names inputEntryCarNames() {
        System.out.println(MESSAGE_ENTRY_CARS_NAME);
        return Names.from(scanner.nextLine());
    }

    public Laps inputLaps() {
        System.out.println(MESSAGE_TYR_COUNT);
        return new Laps(scanner.nextInt());
    }
}
