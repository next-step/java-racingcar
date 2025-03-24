package step4;

import java.awt.*;
import java.sql.Array;
import java.util.List;

public class ResultView {
    public void printResults (List<List<String>> finalResults) {
        for (List<String> round : finalResults) {
            printEachRoundResult(round);
            System.out.println();
        }
    }

    public void printEachRoundResult (List<String> round) {
        for (String s : round) {
            System.out.println(s);
        }
    }

    public void printWinner(List<String> lastRound) {
        String[] winners = [];
        int maxLength = 0;

        for (int i=0; i<lastRound.size(); i++) {
            String[] result = lastRound.get(i).split(" : ");
            if (result[1].length() >= maxLength) {
                maxLength = result[1].length();
                winners.add(result[0]);
            }
        }

        System.out.println(winners + "가 우승했습니다.");
    }

}
