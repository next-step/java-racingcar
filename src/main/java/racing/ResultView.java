package racing;

import java.util.Iterator;
import java.util.List;

public class ResultView {

    private static final String RESULT_DELIMITER = " : ";
    private static final String WINNER_DELIMITER = ",";
    private static final String DASH = "-";

    public ResultView() {
        System.out.println("\n실행 결과\n");
    }

    public void printRaceResult(Cars cars) {
        Iterator<Car> iter = cars.iterator();
        iter.forEachRemaining(car-> System.out.println(car.getName() + RESULT_DELIMITER + DASH.repeat(car.getPosition())));

        System.out.println();
    }

    public void printRaceWinner(Cars cars) {
        List<Car> winners = cars.getWinnerList();
        StringBuilder stringBuilder = new StringBuilder();
        for (Car winner : winners) {
            addDelimiterToStringBuilder(stringBuilder, WINNER_DELIMITER);
            stringBuilder.append(winner.getName());
        }
        System.out.println(stringBuilder + "가 최종 우승했습니다.");
    }

    private void addDelimiterToStringBuilder(StringBuilder stringBuilder, String delimiter) {
        if (stringBuilder.length() > 0) {
            stringBuilder.append(delimiter);
        }
    }

}
