package step4;

import java.util.stream.IntStream;

public class RacingCarResultView {

    static void printRacingCarStatus(OutputView outputView, RacingCar racingCar) {

        IntStream.range(0, racingCar.getNumberOfCar())
                .mapToObj(i -> makeCarStatusToString(racingCar, i))
                .forEach(outputView::print);

    }

    static String makeCarStatusToString(RacingCar racingCar, int index) {
        StringBuilder sb = new StringBuilder();

        sb.append(racingCar.getNameOfCar(index));
        sb.append(" : ");
        sb.append("-".repeat(racingCar.getCarPosition(index)));

        return sb.toString();

    }

}
