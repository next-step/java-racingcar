package edu.nextstep.racing;

import edu.nextstep.racing.domain.CarRacingService;
import edu.nextstep.racing.domain.RoundGameService;
import edu.nextstep.racing.domain.WinPlayerService;
import edu.nextstep.racing.model.Car;
import edu.nextstep.racing.model.Cars;
import edu.nextstep.racing.model.Race;
import edu.nextstep.racing.model.Winner;
import edu.nextstep.racing.view.InputView;
import edu.nextstep.racing.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-15 21:03
 */
public class CarRacingController {

    private InputView ui;
    private ResultView output;
    private CarRacingService carRacingService;
    private RoundGameService roundGameService;
    private WinPlayerService winPlayerService;

    private static final int INIT_SCORE = 0;

    public CarRacingController() {
        this.ui = new InputView();
        this.output = new ResultView();
    }

    public static void main(String[] args) {
        CarRacingController app = new CarRacingController();
        app.start();
    }

    public void start() {
        List<String> carList = ui.getNameOfCars().stream()
                .distinct()
                .collect(Collectors.toList());

        Cars cars = new Cars(carList);
        Race race = new Race(ui.getNumberOfTime());

        this.carRacingService = new CarRacingService(cars);
        this.roundGameService = new RoundGameService(race);

        for (int i = 0; i < this.roundGameService.getGameTime(); i++) {
            Cars viewCarList = this.carRacingService.startRoundGame();
            output.resultView(viewCarList);
        }

        List<Car> finishPlayer = this.carRacingService.finishGame().getCars();
        Winner candidateWinner = new Winner(finishPlayer, INIT_SCORE);
        this.winPlayerService = new WinPlayerService(candidateWinner);
        this.winPlayerService.doWinnerCheck();

        output.printWinnerPlayer(this.winPlayerService.getWinners().getWinners());
    }
}