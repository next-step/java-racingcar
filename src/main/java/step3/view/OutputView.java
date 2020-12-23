package step3.view;

import step3.domain.Car;
import step3.domain.Cars;

import java.util.List;

public class OutputView {

    private static final String DISTANCE_CHARACTER = "-";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String EMPTY_STRING = "";
    private final static String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public void printResult(Cars cars, int rountCount) {
        ViewUtils.printLine(RESULT_MESSAGE);

        for(int i = 0; i < rountCount; i++) {
            printCarsDistance(i, cars);

            ViewUtils.printLine(EMPTY_STRING);
        }

        printWinner(cars);
    }

    private void printCarsDistance(int roundTime, Cars cars) {
        for(Car car : cars.getValue()) {
            ViewUtils.print(car.getName() + " : ");
            int distance = car.getDistanceByRound(roundTime);

            printDistance(distance);
        }
    }

    private void printDistance(int distance) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < distance; i++) {
            builder.append(DISTANCE_CHARACTER);
        }

        ViewUtils.printLine(builder.toString());
    }

    private void printWinner(Cars cars) {
        List<String> winners = cars.getWinnerNames();
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < winners.size(); i++) {
            if(i != 0) {
                builder.append(",");
            }
            builder.append(winners.get(i));
        }
        builder.append(WINNER_MESSAGE);

        ViewUtils.printLine(builder.toString());
    }

}
