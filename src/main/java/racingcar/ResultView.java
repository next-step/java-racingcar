package racingcar;

import racingcar.common.Messages;

import java.io.PrintWriter;
import java.util.List;


public class ResultView {
    private static final int FIRST = 1;
    private final PrintWriter writer;

    public ResultView() {
        this.writer = new PrintWriter(System.out, true);
    }

    public void printGameResult(GameResults results) {
        GameStepList steps = results.getSteps();
        List<String> winners = results.getWinners();

        writer.println(Messages.RESULT_START_MESSAGE.valueOf());

        printAllSteps(steps);
        printWinners(winners);
    }

    private void printAllSteps(GameStepList steps) {
        steps.getSteps()
                .stream().forEach(this::printAllCars);
    }

    private void printAllCars(GameStep step) {
        CarStateList carStateList = step.getCarStateList();

        carStateList.getStates()
                .stream().forEach(this::printCar);

        writer.println(Messages.RESULT_EMPTY_STRING.valueOf());
    }

    private void printCar(CarState stateOfCar) {
        String name = stateOfCar.getName();
        int position = stateOfCar.getPosition();

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
