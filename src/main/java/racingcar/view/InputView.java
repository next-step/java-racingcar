package racingcar.view;

import java.util.Scanner;

public class InputView {
    public static final String REGEX = ",";
    private static Scanner scanner = new Scanner(System.in);

    public String[] carNameView() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return carNameValue(scanner);
    }

    public int carCountView() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return numberValue(scanner);
    }

    public int tryCountView() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return numberValue(scanner);
    }

    private String[] carNameValue(Scanner scanner) {
        return scanner.next().split(REGEX);
    }

    private int numberValue(Scanner scanner) {
        return scanner.nextInt();
    }
}
