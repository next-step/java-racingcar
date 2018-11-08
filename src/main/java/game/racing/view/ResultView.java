package game.racing.view;

import game.racing.domain.GameResult;

public class ResultView {
    public static void print(GameResult result) {
        result.getCurrentStates().forEach(System.out::println);
    }

    public static void printWinner(GameResult result) {
        System.out.println(String.join(", ", result.getWinnerNames()) + "가 최종 우승했습니다.");
    }


}
