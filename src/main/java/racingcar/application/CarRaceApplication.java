package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.CarRace;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class CarRaceApplication {
    public static void main(String[] args) {
        InputView input = new InputView();
        List<String> carNames = input.getCarNames();
        int runCount = input.getRunCount();

        CarRace carRace = new CarRace(createCars(carNames), runCount);
        List<List<Integer>> result = carRace.run();

        ResultView output = new ResultView();
        output.print(result);
    }

    private static List<Car> createCars(List<String> carNames) {
        return  carNames.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }
}
