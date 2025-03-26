package step4.view;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ResultView {
    List<Map<String, Integer>>  finalResults; // 숫자(Integer)로 표시된 결과
    List<List<String>> drawResults; // 문자(-)로 표시한 결과

    public ResultView(List<Map<String, Integer>> finalResults) {
        this.finalResults = finalResults;
    }

    public void showResult () {
        drawFinalResult();
        printFinalResult();
        printWinners(finalResults.get(finalResults.size() - 1));
    }

    private void drawFinalResult() {
        List<List<String>> DrawResults = new ArrayList<>();
        for (Map<String, Integer>  round : finalResults) {
            List<String> RoundResults = drawEachRoundResult(round);
            DrawResults.add(RoundResults);
        }
        this.drawResults = DrawResults;
    }

    private List<String> drawEachRoundResult(Map<String, Integer> round) {
        List<String> roundResults = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : round.entrySet()) {
            String carName = entry.getKey();
            int position = entry.getValue();
            String result = carName + " : " + "-".repeat(position);
            roundResults.add(result);
        }
        return roundResults;
    }

    private void printFinalResult () {
        for (List<String> round : this.drawResults) {
            printEachRoundResult(round);
            System.out.println();
        }
    }

    private void printEachRoundResult(List<String> round) {
        for (String s : round) {
            System.out.println(s);
        }
    }

    public static void printWinners(Map<String, Integer> lastRound) {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;

        for (Map.Entry<String, Integer> entry : lastRound.entrySet()) {
            String carName = entry.getKey();
            int position = entry.getValue();

            if (position > maxPosition) {
                maxPosition = position;
                winners.clear();
                winners.add(carName);
            } else if (position == maxPosition) {
                winners.add(carName);
            }
        }

        System.out.println(String.join(", ", winners) + "가 우승했습니다.");
    }

}
