package nextstep.javaracingcar.view;

import nextstep.javaracingcar.CarDrivingResult;

import java.util.List;

public class ResultView {
    private final OutputConsumer outputConsumer;

    public ResultView(OutputConsumer outputConsumer) {
        this.outputConsumer = outputConsumer;
    }

    public void printReusltTitle() {
        printEmptyLine();
        this.outputConsumer.write("실행 결과");
    }

    public void printResult(final List<CarDrivingResult> racingResults) {
        for (CarDrivingResult racingResult : racingResults) {
            final StringBuffer sb = new StringBuffer("-");
            final Iterable<Integer> distanceIterable = racingResult.distance().toIterable();
            distanceIterable.forEach(i -> sb.append("-"));
            outputConsumer.write(sb.toString());
        }
        printEmptyLine();
    }

    private void printEmptyLine() {
        outputConsumer.write("");
    }
}
