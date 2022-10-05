package racing.view;


import racing.domain.CarGroup;
import racing.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private static final String RESULT = "\n실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String TRACE = "-";
    private static final String NAME_TRACE_DELIMITER = " : ";
    private static final String NAME_DELIMITER = ", ";

    private ResultView() {}

    public static void printWinner(List<Car> winners) {
        print(nameOfWinners(winners) + WINNER_MESSAGE);
    }

    public static void printRoundResult(CarGroup carGroup) {
        for (Car car : carGroup.getCars()) {
            print(car.getName() + NAME_TRACE_DELIMITER + carTrace(car.getPosition()));
        }
        print("");
    }

    private static String nameOfWinners(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        addWinnerNames(winners, winnerNames);
        return String.join(NAME_DELIMITER, winnerNames);
    }

    private static void addWinnerNames(List<Car> winners, List<String> winnerNames) {
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
    }

    private static String carTrace(int position) {
        return drawTrace(position);
    }

    private static String drawTrace(int carPosition) {
        return TRACE.repeat(carPosition);
    }

    private static void print(String message) {
        System.out.println(message);
    }

}
