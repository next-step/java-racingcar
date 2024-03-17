package racingcar.presentation;

import racingcar.application.RacingCarService;
import racingcar.domain.Car;

import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final ResultView resultView;
    private final RacingCarService racingCarService;

    public RacingCarController(InputView inputView, ResultView resultView, RacingCarService racingCarService) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.racingCarService = racingCarService;
    }

    public void startGame() {
        List<String> carNames = inputView.inputCarNames();
        int repeatNumber = inputView.inputRepeatNumber();

        racingCarService.initCars(carNames);

        System.out.println("실행 결과");

        for (int i = 0; i < repeatNumber; i++) {
            racingCarService.moveCar();
            List<Car> cars = racingCarService.cars();
            resultView.printMoveResult(cars);
        }
        resultView.printWinner(racingCarService.winnerCars());
    }
}
