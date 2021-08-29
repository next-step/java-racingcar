package race;

import java.util.Iterator;
import java.util.List;

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

    public static void printWinner(List<String> winner) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iter = winner.listIterator();
        sb.append(iter.next());
        while (iter.hasNext()) {
            sb.append(",").append(iter.next());
        }
        System.out.println(sb.toString() + "가 최종 우승했습니다.");
    }
}
