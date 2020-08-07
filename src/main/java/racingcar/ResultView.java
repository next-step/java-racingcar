package racingcar;

import racingcar.common.Messages;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;


public class ResultView {
    private static final int FIRST = 1;
    private final PrintWriter writer;

    public ResultView() {
        this.writer = new PrintWriter(System.out, true);
    }

    public void printGameResult(GameResults results) {
        List<Map<String, Integer>> steps = results.getSteps();
        List<String> winners = results.getWinners();

        writer.println(Messages.RESULT_START_MESSAGE.valueOf());

        printAllSteps(steps);
        printWinners(winners);
    }

    private void printAllSteps(List<Map<String, Integer>> steps) {
        for (Map<String, Integer> step : steps) {
            printAllCars(step);
        }
    }

    private void printAllCars(Map<String, Integer> cars) {
        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            this.printCar(car);
        }
        writer.println(Messages.RESULT_EMPTY_STRING.valueOf());
    }

    private void printCar(Map.Entry<String, Integer> car) {
        String name = car.getKey();
        int position = car.getValue();

        writer.print(name + Messages.RESULT_CAR_STATE_SPERATOR.valueOf());

        for (int i = 0; i < position; ++ i) {
            writer.print(Messages.RESULT_CAR_SHAPE.valueOf());
        }
        writer.println(Messages.RESULT_EMPTY_STRING.valueOf());
    }

    private void printWinners(List<String> winners) {
        int idx = FIRST;
        int size = winners.size();

        for (String winner : winners) {
            printWinner(winner, isNotLastElement(idx++, size));
        }

        writer.println(Messages.RESULT_WINNER_STRING.valueOf());
    }

    private boolean isNotLastElement(int idx, int size) {
        return idx < size;
    }

    private void printWinner(String winner, boolean isNotLast) {
        writer.print(winner);

        if (isNotLast) {
            writer.print(Messages.RESULT_WINNER_SEPERATOR.valueOf());
        }
    }
}
