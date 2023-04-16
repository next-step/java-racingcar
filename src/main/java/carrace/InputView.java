package carrace;

import java.util.Scanner;

public enum InputView {
    HOW_MANY_CARS("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    HOW_MANY_LABS("시도할 회수는 몇 회 인가요?");

    private static final Scanner SCANNER = new Scanner(System.in);
    private final String description;

    InputView(String description) {
        this.description = description;
    }

    public String getAnswer() {
        System.out.println(description);
        return SCANNER.nextLine();
    }
}
