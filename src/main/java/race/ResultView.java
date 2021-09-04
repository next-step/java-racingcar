package race;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    protected static void printResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " :" + convertDistanceToLine(car));
        }
        System.out.println();
    }

    private static String convertDistanceToLine(Car car) {
        StringBuilder sb = new StringBuilder();
        for (Boolean b : car.getWinOrLoseLog()) {
            sb.append(b ? "-" : "");
        }
        return sb.toString();
    }

    public static void printWinner(List<Car> winner) {
        StringBuilder sb = new StringBuilder();
        List<String> winnerNames =
                winner.stream()
                        .map(Car::getName)
                        .collect(Collectors.toList());
        Iterator<String> iter = winnerNames.listIterator();
        sb.append(iter.next());
        while (iter.hasNext()) {
            sb.append(",").append(iter.next());
        }
        System.out.println(sb.toString() + "가 최종 우승했습니다.");
    }
}
