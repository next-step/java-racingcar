package carracing.ui;

import carracing.Car;

import java.util.ArrayList;
import java.util.List;

import static carracing.GameWinner.getWinnerPoint;
import static carracing.GameWinner.findWinners;

public class ResultView {

    private static final StringBuilder sb = new StringBuilder();

    private ResultView() {}

    public static String createNameAndPositionView(String name, int position) {
        sb.setLength(0);

        sb.append(name);
        sb.append(" : ");
        sb.append(("-".repeat(position)));

        return sb.toString();
    }

    public static void carRacingWinnersView(List<Car> winners) {
        List<String> winnersNameBox = new ArrayList<>();
        int winnerPoint = getWinnerPoint();

        findWinners(winners, winnerPoint, winnersNameBox);

        System.out.println(String.join(", ", winnersNameBox) + "가 최종 우승했습니다.");
    }

    public static void printResultRaceGameProcess(Car car) {
        String nameAndPositionView = ResultView.createNameAndPositionView(car.getName(), car.getPosition());
        System.out.println(nameAndPositionView);
    }

}
