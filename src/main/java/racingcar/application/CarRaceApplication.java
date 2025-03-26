package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.CarRace;
import racingcar.domain.CarState;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class CarRaceApplication {
    public static void main(String[] args) {
        InputView input = new InputView();
        List<Car> cars = createCars(input.getCarNames());
        int runCount = input.getRunCount();

        CarRace carRace = new CarRace(cars, runCount, new RandomNumberGenerator());
        List<List<CarState>> result = carRace.run();
        List<Car> winners = carRace.findWinners();

        ResultView output = new ResultView();
        output.print(result);
        output.printWinners(winners);
    }

    private static List<Car> createCars(List<String> carNames) {
        return  carNames.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }
}
