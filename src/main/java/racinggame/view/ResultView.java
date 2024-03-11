package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Position;
import racinggame.domain.RaceRecord;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private static final String WINNER_SEPARATOR = ", ";
    private ResultView() {
    }

    public static void display(List<RaceRecord> raceRecord) {
        for (RaceRecord record : raceRecord) {
            System.out.println(playRecord(record));
        }
        System.out.println(showWinner(raceRecord.get(raceRecord.size() - 1)));
    }

    private static String playRecord(RaceRecord record) {
        StringBuilder result = new StringBuilder();
        for (Car car : record.getCars()) {
            result.append(car.name())
                    .append(" : ")
                    .append("-".repeat(car.position().getPosition()))
                    .append("\n");
        }
        return result.toString();
    }

    private static String showWinner(RaceRecord lastRecord) {
        return joinWithSeparator(getWinnerNames(lastRecord.getWinners())) + "가 최종 우승했습니다.";
    }

    private static List<String> getWinnerNames(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winners) {
            winnerNames.add(car.name());
        }
        return winnerNames;
    }

    private static String joinWithSeparator(List<String> winnerName) {
        String result = winnerName.get(0);

        if(winnerName.size() == 1) {
            return result;
        }

        for (int i = 1; i < winnerName.size(); i++) {
            result += WINNER_SEPARATOR + winnerName.get(i);
        }
        return result;
    }
}
