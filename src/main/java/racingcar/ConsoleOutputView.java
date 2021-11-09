package racingcar;

import java.util.List;
import java.util.stream.IntStream;

public class ConsoleOutputView implements OutputView{
    private final int STARTING_POINT = 0;
    private final char PROGRESS_BAR = '-';

    @Override
    public void showOutputMessage() {
        System.out.println("Result of Racing");
    }

    @Override
    public void showStartOfRound(int round) {
        System.out.printf("Round %d Starts!\n", round);
    }

    @Override
    public void showEndOfRound(int round) {
        System.out.printf("Round %d Is Finished!\n\n", round);
    }

    @Override
    public void showRacing(List<Integer> progressOfCars) {
        progressOfCars.forEach(this::showDistanceOfCar);
    }

    public void showDistanceOfCar(int distance) {
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(STARTING_POINT, distance)
                .forEach(i -> stringBuilder.append(PROGRESS_BAR));

        System.out.println(stringBuilder);
    }
}
