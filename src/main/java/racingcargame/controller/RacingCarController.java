package racingcargame.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcargame.domain.common.Names;
import racingcargame.domain.game.RacingCarGame;
import racingcargame.domain.vehicle.Car;
import racingcargame.domain.vehicle.Cars;
import racingcargame.domain.vehicle.factory.CarFactory;
import racingcargame.domain.vehicle.factory.NormalCarFactory;
import racingcargame.view.InputView;
import racingcargame.view.ResultView;

public class RacingCarController {

    private static final CarFactory NORMAL_CAR_FACTORY = new NormalCarFactory();

    public static void main(String[] args) {
        RacingCarGame game = createRacingCarGame();

        ResultView.println("");
        ResultView.println("실행 결과");

        for (int i = 0; i < game.getRoundCount(); i++) {
            game.playing();
            ResultView.pirntProgress(game.getCars());
        }

        ResultView.printWinners(game.getCars());
    }

    private static RacingCarGame createRacingCarGame() {
        Names names = InputView.inputCarNames();
        int roundCount = InputView.inputRoundCount();

        List<Car> carList = names.getNames()
            .stream()
            .map(NORMAL_CAR_FACTORY::create)
            .collect(Collectors.toList());
        Cars cars = new Cars(carList);

        return new RacingCarGame(cars, roundCount);
    }
}
