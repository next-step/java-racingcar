package step3;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    List<List<Integer>> FinalResults; // 숫자(Integer)로 표시된 결과
    List<List<String>> DrawResults; // 문자(-)로 표시한 결과

    public ResultView(List<List<Integer>> finalResults) {
        this.FinalResults = finalResults;
    }

    public void showResult () {
        drawFinalResult();
        printFinalResult();
    }

    private void drawFinalResult() {
        List<List<String>> DrawResults = new ArrayList<>();
        for (List<Integer> round : FinalResults) {
            List<String> RoundResults = drawEachRoundResult(round);
            DrawResults.add(RoundResults);
        }
        this.DrawResults = DrawResults;
    }


    private List<String> drawEachRoundResult(List<Integer> round) {
        List<String> RoundResults = new ArrayList<>();
        for (int position : round) {
            String result =  "-".repeat(position);
            RoundResults.add(result);
        }
        return RoundResults;
    }

    private void printFinalResult () {
        for (List<String> round : this.DrawResults) {
            printEachRoundResult(round);
            System.out.println();
        }
    }

    private void printEachRoundResult(List<String> round) {
        for (String s : round) {
            System.out.println(s);
        }
    }
}
