package racingGame;

import java.util.List;

public class ResultView {
    public void printRound(int roundIndex, List<Racing.CarSnapshot> round) {
        System.out.println("Round " + (roundIndex + 1));
        for (Racing.CarSnapshot s : round) {
            System.out.println(s.name + " : " + "-".repeat(s.position));
        }
        System.out.println();
    }
}
