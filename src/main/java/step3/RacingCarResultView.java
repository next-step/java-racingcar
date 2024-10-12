package step3;

import java.util.stream.IntStream;

public class RacingCarResultView {

    static void printRacingCarStatus(OutputView outputView, RacingCar racingCar) {

        IntStream.range(0, racingCar.getNumberOfCar())
                .mapToObj(i -> "-".repeat(racingCar.getCarPosition(i)))
                .forEach(outputView::print);

    }

}
