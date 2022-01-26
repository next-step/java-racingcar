package racingcar.view;

import java.util.Scanner;
import racingcar.domain.Participants;
import racingcar.domain.Turn;

public class UserConsole {

    private static Scanner scanner = new Scanner(System.in);
    private static final String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TURN_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String COMMA = ",";

    public static String getConsoleTextFrom(String message) {
        System.out.println(message);
        String line = scanner.nextLine().trim();
        return line;
    }

    public static Participants names() {
        try {
            String names = getConsoleTextFrom(NAME_MESSAGE);
            return Participants.createCars(names.split(COMMA));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return names();
        }
    }

    public static Turn turn() {
        try {
            String turn = getConsoleTextFrom(TURN_MESSAGE);
            return Turn.createTurn(turn);
        } catch (NumberFormatException | IllegalStateException e) {
            e.printStackTrace();
            return turn();
        }
    }
}
