package racingcar.view;

import java.util.Scanner;

public class InputView {
    public int carCountView(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return numberValue(scanner);
    }

    public int tryCountView(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return numberValue(scanner);
    }

    private int numberValue(Scanner scanner) {
        return scanner.nextInt();
    }
}
