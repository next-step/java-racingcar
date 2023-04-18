package racing.view;

import racing.domain.Game;
import racing.domain.GameStatus;
import racing.domain.Name;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ResultView {
    private static final char PRINT_POSITION_CHAR = '-';

    public static void printStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printGameStatus(Game game) {
        GameStatus status = game.getStatus();
        Set<String> participants = status.getParticipants();
        for (String participant : participants) {
            printCarStatus(participant, status.getPositionByName(participant));
        }
        System.out.println();
    }

    public static void printCarStatus(String name, int position) {
        printName(name);
        printOngoingStatus(position);
        System.out.println();
    }

    private static void printOngoingStatus(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(PRINT_POSITION_CHAR);
        }
    }

    private static void printName(String name) {
        System.out.print(name + " : ");
    }

    public static void printWinner(Game game) {
        List<String> winnerNames = game.getWinnerNames()
                .stream()
                .map(Name::getName)
                .collect(Collectors.toList());

        System.out.print(String.join(", ", winnerNames));
        System.out.println("가 최종 우승했습니다.");
    }
}
