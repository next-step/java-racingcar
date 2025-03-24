package step4;

import java.awt.*;
import java.sql.Array;
import java.util.List;
import java.util.ArrayList;

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
        List<String> winners = new ArrayList<>();
        int maxLength = 0;

        for (String result : lastRound) {
            String[] parts = result.split(" : ");
            int length = parts[1].length();
            if (length > maxLength) {
                maxLength = length;
                winners.clear();
                winners.add(parts[0]);
            } else if (length == maxLength) {
                winners.add(parts[0]);
            }
        }

        System.out.println(String.join(", ", winners) + "가 우승했습니다.");
    }

}
