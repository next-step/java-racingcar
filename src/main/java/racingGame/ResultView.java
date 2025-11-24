package racingGame;

import java.util.List;

public class ResultView {

    public void print(List<Round> rounds, List<String> names, List<String> winners) {
        System.out.println();
        System.out.println("실행 결과");

        for (Round round : rounds) {
            printRound(round, names);
        }

        printWinners(winners);
    }

    private void printRound(Round round, List<String> names) {
        List<Integer> positions = round.positions();

        for (int i = 0; i < names.size(); i++) {
            String line = drawLine(names.get(i), positions.get(i));
            System.out.println(line);
        }
        System.out.println();
    }

    private String drawLine(String name, int position) {
        int safePosition = Math.max(0, position);
        return name + " : " + "-".repeat(safePosition);
    }

    private void printWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(winners.get(i));
        }
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }
}
