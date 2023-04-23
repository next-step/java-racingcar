package view;

import java.util.List;

import domain.GameResultResponse;

public class ResultView {

    public static void outputView(GameResultResponse gameResultResponse) {
        List<String[]> result = gameResultResponse.getGameResult();
        for (int i = 0; i < result.size(); i++) {
            printEachRound(result.get(i));
            System.out.println();
        }
    }

    public static void printEachRound(String[] eachRound) {
        for (String s : eachRound) {
            System.out.println(s);
        }
    }

    public static void printWinner(List<String> winnerList) {
        for (int i=0; i < winnerList.size(); i++) {
            System.out.print(winnerList.get(i));
            if (i < winnerList.size() - 1) {
                System.out.print(", ");
            }

        }
        System.out.print("가 최종 우승했습니다.");
    }


}
