package racingcar.view;

import java.util.ArrayList;

public class OutputView {

    private final String GAME_RESULT_MESSAGE = "출력결과";
    private final String WINNER_MESSAGE = "최종 우승자: ";

    public void printResult(String carName, String position) {
        System.out.println(GAME_RESULT_MESSAGE);
        System.out.println(carName + ": " + position);
    }

    public void printWinner(ArrayList<String> winnerList) {
        System.out.print(WINNER_MESSAGE);
        System.out.print(String.join(",", winnerList));
    }
}
