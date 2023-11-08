package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RaceCommand;
import racingcar.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.view.InputView.inputRaceCommand;

public class RacingCarApplication {
    public static void main(String[] args) {
        RaceCommand raceCommand = inputRaceCommand();
        List<Car> cars = IntStream.range(0, raceCommand.getCarCount())
                                  .mapToObj(i -> new Car(0))
                                  .collect(Collectors.toList());
        ResultView.startAndDisplay(cars,
                                   raceCommand.getTryCount());
    }
}
