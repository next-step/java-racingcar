package carrace;

import java.util.Scanner;

public enum InputView {
    HOW_MANY_CARS("자동차 대수는 몇 대 인가요?"),
    HOW_MANY_LABS("시도할 회수는 몇 회 인가요?");

    private static final Scanner SCANNER = new Scanner(System.in);
    private final String description;

    InputView(String description) {
        this.description = description;
    }

    public int getAnswer() {
        System.out.println(description);
        return SCANNER.nextInt();
    }
}
