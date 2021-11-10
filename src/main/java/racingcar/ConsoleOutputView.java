package racingcar;

import java.util.List;
import java.util.stream.IntStream;

public class ConsoleOutputView implements OutputView{
    private final int STARTING_POINT = 0;
    private final char PROGRESS_BAR = '-';
    private final String SEPARATOR_OF_CAR_STATE = " : ";
    private final String SEPARATOR_OF_WINNERS = ", ";
    private final String MESSAGE_OF_WINNERS = " has (have) finally won!";

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
    public void showRacing(List<CarState> progressOfCars) {
        progressOfCars.forEach(this::showDistanceOfCar);
    }

    private void showDistanceOfCar(CarState carState) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(carState.getName());
        stringBuilder.append(SEPARATOR_OF_CAR_STATE);
        IntStream.range(STARTING_POINT, carState.getDistance())
                .forEach(i -> stringBuilder.append(PROGRESS_BAR));

        System.out.println(stringBuilder);
    }

    @Override
    public void showWinners(List<CarState> winners) {
        StringBuilder stringBuilder = new StringBuilder();

        winners.forEach(winner -> {
            stringBuilder.append(winner.getName());
            stringBuilder.append(SEPARATOR_OF_WINNERS);
        });

        int lengthOfMessage = stringBuilder.length();
        stringBuilder.delete(lengthOfMessage-SEPARATOR_OF_WINNERS.length(), lengthOfMessage);

        stringBuilder.append(MESSAGE_OF_WINNERS);

        System.out.println(stringBuilder);
    }
}
