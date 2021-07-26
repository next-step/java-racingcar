package racingcargame.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcargame.domain.common.Names;
import racingcargame.domain.vehicle.Car;
import racingcargame.domain.vehicle.Cars;
import racingcargame.domain.vehicle.factory.CarFactory;
import racingcargame.domain.vehicle.factory.NormalCarFactory;
import racingcargame.view.InputView;
import racingcargame.view.ResultView;

public class RacingCarController {

    private static final CarFactory NORMAL_CAR_FACTORY = new NormalCarFactory();

    public static void main(String[] args) {
        Cars racingCars = inputRacingCars();
        int roundCount = InputView.inputRoundCount();

        doDrive(racingCars, roundCount);

        ResultView.printWinners(racingCars);
    }

    private static void doDrive(Cars racingCars, int roundCount) {
        ResultView.println("");
        ResultView.println("실행 결과");

        for (int i = 0; i < roundCount; i++) {
            racingCars.doDrive();
            ResultView.pirntProgress(racingCars);
        }
    }

    private static Cars inputRacingCars() {
        Names names = InputView.inputCarNames();
        List<Car> carList = names.getNames()
            .stream()
            .map(NORMAL_CAR_FACTORY::create)
            .collect(Collectors.toList());

        return new Cars(carList);
    }
}
