package carracing;

import java.util.List;

public class ResultView {
    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(getPositionString(car.getPosition()));
        }
    }

    private String getPositionString(int position) {
        return "-".repeat(Math.max(0, position));
    }

    public void printRoundSeparator() {
        System.out.println();
    }
}
