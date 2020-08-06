package racingcar;

import racingcar.common.Messages;

import java.io.PrintWriter;
import java.util.List;


public class ResultView {
    private final PrintWriter writer;

    public ResultView() {
        this.writer = new PrintWriter(System.out, true);
    }

    public void printGameResult(GameResults results) {
        List<List<Integer>> steps = results.getSteps();

        writer.println(Messages.RESULT_START_MESSAGE.valueOf());

        for (List<Integer> step : steps) {
            printAllSteps(step);
        }
    }

    private void printAllSteps(List<Integer> positions) {
        for (int pos : positions) {
            this.printCar(pos);
        }
        writer.println(Messages.RESULT_EMPTY_STRING.valueOf());
    }

    private void printCar(int position) {
        for (int i = 0; i < position; ++ i) {
            writer.print(Messages.RESULT_CAR_SHAPE.valueOf());
        }
        writer.println(Messages.RESULT_EMPTY_STRING.valueOf());
    }
}
