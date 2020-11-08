package study.racingcar.view;

import study.racingcar.car.Car;
import study.racingcar.car.CarSnapshot;
import study.racingcar.racingcars.RacingCarsSnapshot;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final ResultView instance = new ResultView();
    private static final String NEW_LINE = "\n";

    public static ResultView getInstance() {
        return instance;
    }

    private ResultView() {}

    public void displayCurrentStatus(RacingCarsSnapshot racingCarsSnapshot) {

        for (CarSnapshot carSnapshot : racingCarsSnapshot.getCarSnapshot()) {

            displayCarName(carSnapshot);

            stringBuilder.append(" : ");

            displayCarCurrentPosition(carSnapshot);

            // stringBuilder.append(NEW_LINE);

            printAndClear();
        }

        // stringBuilder.append(NEW_LINE);
        printAndClear();

    }

    private void displayCarName(CarSnapshot carSnapshot) {
        stringBuilder.append(carSnapshot.getName());
    }

    private void displayCarCurrentPosition(CarSnapshot carSnapshot) {
        for (int position = 0; position < carSnapshot.getCurrentPosition(); position++) {
            stringBuilder.append('-');
        }
    }

    public void displayWinner(List<CarSnapshot> winnerSnapshots) {

        List<String> nameOfWinners = winnerSnapshots.stream()
                .map(CarSnapshot::getName)
                .collect(Collectors.toList());

        stringBuilder.append("Winner: [");
        stringBuilder.append(String.join(",", nameOfWinners));
        stringBuilder.append("]");

        printAndClear();
    }

    private void printAndClear() {
        print();
        clear();
    }

    private void print() {
        System.out.println(stringBuilder.toString());
    }

    private void clear() {
        stringBuilder.setLength(0);
    }
}
