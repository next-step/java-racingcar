package edu.nextstep.racing;

import edu.nextstep.racing.domain.CarRacing;
import edu.nextstep.racing.domain.RoundGame;
import edu.nextstep.racing.domain.WinPlayer;
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
public class CarRacingApplication {

    private InputView ui;
    private ResultView output;
    private CarRacing carRacing;
    private RoundGame roundGame;
    private WinPlayer winPlayer;

    private static final int INIT_SCORE = 0;

    public CarRacingApplication() {
        this.ui = new InputView();
        this.output = new ResultView();
    }

    public static void main(String[] args) {
        CarRacingApplication app = new CarRacingApplication();
        app.start();
    }

    public void start() {
        List<String> carList = ui.getNameOfCars()
                .stream()
                .distinct()
                .collect(Collectors.toList());

        Cars cars = new Cars(carList);
        Race race = new Race(ui.getNumberOfTime());

        this.carRacing = new CarRacing(cars);
        this.roundGame = new RoundGame(race);

        for (int i = 0; i < this.roundGame.getGameTime(); i++) {
            List<Car> viewCarList = this.carRacing.starRoundGame();
            output.resultView(viewCarList);
        }
        this.winPlayer = new WinPlayer(new Winner(this.carRacing.finishGame().getCars(), INIT_SCORE));
        this.winPlayer.doWinnerCheck();

        output.printWinnerPlayer(this.winPlayer.getWinners().getWinners());
    }
}