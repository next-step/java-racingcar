package racingGame;

import java.util.List;

public class ResultView {

    public void print(List<Round> rounds) {
        System.out.println("실행 결과");

        for (Round round : rounds) {
            printRound(round);
        }
    }

    private void printRound(Round round) {
        List<String> lines = round.drawLines();

        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println();
    }
}
