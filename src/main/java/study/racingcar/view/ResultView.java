package study.racingcar.view;

import study.racingcar.car.Car;
import study.racingcar.car.CarSnapshot;
import study.racingcar.racingcars.RacingCarsSnapshot;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final ResultView instance = new ResultView();

    public static ResultView getInstance() {
        return instance;
    }

    private ResultView() {}

    public void displayCurrentStatus(RacingCarsSnapshot racingCarsSnapshot) {

        for (CarSnapshot carSnapshot : racingCarsSnapshot.getCarSnapshot()) {

            displayCarName(carSnapshot);

            System.out.print(" : ");

            displayCarCurrentPosition(carSnapshot);

            System.out.println();
        }

        System.out.println();

    }

    private void displayCarName(CarSnapshot carSnapshot) {
        System.out.print(carSnapshot.getName());
    }

    private void displayCarCurrentPosition(CarSnapshot carSnapshot) {
        for (int position = 0; position < carSnapshot.getCurrentPosition(); position++) {
            System.out.print('-');
        }
    }

    public void displayWinner(List<CarSnapshot> winnerSnapshots) {

        List<String> nameOfWinners = winnerSnapshots.stream()
                .map(CarSnapshot::getName)
                .collect(Collectors.toList());

        String winnerMessage = String.format("Winner: [%s]"
                , String.join(",", nameOfWinners));

        System.out.println(winnerMessage);
    }
}
