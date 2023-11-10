package carracing.ui;

import carracing.Car;

import java.util.List;

import static carracing.GameWinner.findWinners;
import static carracing.GameWinner.getWinnerPoint;

public class ResultView {

    private static final StringBuilder sb = new StringBuilder();

    private ResultView() {
    }

    public static String createNameAndPositionView(String name, int position) {
        sb.setLength(0);

        sb.append(name);
        sb.append(" : ");
        sb.append(("-".repeat(position)));

        return sb.toString();
    }

    public static void carRacingWinnersView(List<Car> winners) {
        int winnerPoint = getWinnerPoint();

        List<String> finalWinner = findWinners(winners, winnerPoint);

        System.out.println(String.join(", ", finalWinner) + "가 최종 우승했습니다.");
    }

    public static void printResultRaceGameProcess(Car car) {
        String nameAndPositionView = createNameAndPositionView(car.getName(), car.getPosition());
        System.out.println(nameAndPositionView);
    }

}
