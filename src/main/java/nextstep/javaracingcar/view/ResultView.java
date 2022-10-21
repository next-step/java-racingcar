package nextstep.javaracingcar.view;

import nextstep.javaracingcar.domain.CarDrivingResult;
import nextstep.javaracingcar.domain.CarRacingResult;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private final OutputConsumer outputConsumer;

    public ResultView(OutputConsumer outputConsumer) {
        this.outputConsumer = outputConsumer;
    }

    public void printResultTitle() {
        printEmptyLine();
        this.outputConsumer.write("실행 결과");
    }

    public void printResult(final CarRacingResult racingResult) {
        for (CarDrivingResult drivingResult : racingResult) {
            final StringBuilder sb = new StringBuilder(drivingResult.name() + " : -");
            final Iterable<Integer> distanceIterable = drivingResult.distance().toIterable();
            distanceIterable.forEach(i -> sb.append("-"));
            outputConsumer.write(sb.toString());
        }
        printEmptyLine();
    }

    private void printEmptyLine() {
        outputConsumer.write("");
    }

    public void printWinners(final CarRacingResult result) {
        final List<CarDrivingResult> winners = result.winners();
        final String winnerNames = winners.stream().map(CarDrivingResult::name).collect(Collectors.joining(", "));
        outputConsumer.write(winnerNames + "가 최종 우승했습니다.");
    }
}
