package step4;

import java.util.stream.IntStream;

public class RacingCarResultView {

    static void printRacingCarWinner(OutputView outputView, RacingCar racingCar) {
        outputView.print(makeCarWinnerToString(racingCar));
    }

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
        sb.append("\n");

        return sb.toString();

    }

    static String makeCarWinnerToString(RacingCar racingCar) {
        StringBuilder sb = new StringBuilder();
        String winners = String.join(", ", racingCar.getWinner());

        sb.append(winners);
        sb.append("가 최종 우승했습니다.");
        sb.append("\n");

        return sb.toString();
    }

}
