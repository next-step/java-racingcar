package carracing;

import java.util.List;

public class ResultView {
    private static final String CAR_MOVESTATUS_DASH = "-";
    private static final String NEW_LINE = System.lineSeparator();

    private final StringBuilder output;

    public ResultView() {
        this.output = new StringBuilder("실행 결과").append(NEW_LINE);
    }

    public StringBuilder getOutput() {
        return output;
    }

    public void saveCarsMoveStatus(List<Car> cars) {
        for (Car car : cars) {
            this.output.append(CAR_MOVESTATUS_DASH.repeat(Math.max(0, car.getMoveStatus())))
                    .append(NEW_LINE);
        }
        this.output.append(NEW_LINE);
    }

    public void printCarRacingResult() {
        System.out.println(this.output);
    }
}
