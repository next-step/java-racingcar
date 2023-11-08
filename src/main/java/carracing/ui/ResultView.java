package carracing.ui;

import carracing.Car;

import java.util.ArrayList;
import java.util.List;

import static carracing.GameWinner.getWinnerPoint;

public class ResultView {
    private ResultView() {
    }

    public static String createNameAndPositionView(String name, int position) {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" : ");
        sb.append(("-".repeat(position)));

        return sb.toString();
    }

    public static void carRacingWinnersView(List<Car> winners) {
        List<String> winnersNameBox = new ArrayList<>();
        int winnerPoint = getWinnerPoint();

        for (Car winner : winners) {
            if (winner.getPrevPosition() == winnerPoint) {
                winnersNameBox.add(winner.getName());
            }
        }

        System.out.println(String.join(", ", winnersNameBox) + "가 최종 우승했습니다.");
    }
}
