package racing.ui;

import java.util.Scanner;

public class InputView implements View {
    private final Scanner scanner = new Scanner(System.in);

    public final String PROMPT_PARTICIPANTS_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    public final String PROMPT_LABS_MESSAGE = "시도할 횟수는 몇 회 인가요?";

    @Override
    public void display(String content) {
        System.out.println(content);
    }

    public int receiveInt(String helpMessage) {
        display(helpMessage);
        return scanner.nextInt();
    }

    public int promptParticipantsCount() {
        return receiveInt(PROMPT_PARTICIPANTS_COUNT_MESSAGE);
    }

    public int promptLaps() {
        return receiveInt(PROMPT_LABS_MESSAGE);
    }
}
