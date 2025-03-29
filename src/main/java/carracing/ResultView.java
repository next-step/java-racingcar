package carracing;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getPositionString(car.getPosition()));
        }
    }

    private String getPositionString(int position) {
        return "-".repeat(Math.max(0, position));
    }

    public void printRoundSeparator() {
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
