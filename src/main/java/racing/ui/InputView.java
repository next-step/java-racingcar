package racing.ui;

import java.util.Scanner;

public class InputView implements View {
    private final Scanner scanner = new Scanner(System.in);

    public static final String PROMPT_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String PROMPT_LABS_MESSAGE = "시도할 횟수는 몇 회 인가요?";

    @Override
    public void display(String content) {
        System.out.println(content);
    }

    public int receiveInt(String helpMessage) {
        display(helpMessage);
        return scanner.nextInt();
    }

    public String receiveString(String helpMessage) {
        display(helpMessage);
        return scanner.nextLine();
    }

    public String promptNames() {
        return receiveString(PROMPT_NAMES_MESSAGE);
    }

    public int promptLaps() {
        return receiveInt(PROMPT_LABS_MESSAGE);
    }
}
