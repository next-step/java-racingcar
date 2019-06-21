package edu.nextstep.racing;

import edu.nextstep.racing.domain.CarRacingService;
import edu.nextstep.racing.model.Car;
import edu.nextstep.racing.model.Cars;
import edu.nextstep.racing.model.Race;
import edu.nextstep.racing.view.InputView;
import edu.nextstep.racing.view.ResultView;

import java.util.ArrayList;
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

    public CarRacingController() {
        this.ui = new InputView();
        this.output = new ResultView();
    }

    public static void main(String[] args) {
        CarRacingController app = new CarRacingController();
        app.start();
    }

    public void start() {
        List<String> inputCarList = ui.getNameOfCars().stream()
                .distinct()
                .collect(Collectors.toList());

        List<Car> carlist = new ArrayList<>();
        for (String carName : inputCarList) {
            carlist.add(new Car(carName));
        }

        Cars cars = new Cars(carlist);
        Race race = new Race(ui.getNumberOfTime());

        this.carRacingService = new CarRacingService(cars, race);

        int totalRaceTime = this.carRacingService.getGameTime();

        for (int i = 0; i < totalRaceTime; i++) {
            Cars viewCarList = this.carRacingService.startRoundGame();
            output.resultView(viewCarList);
        }

        Cars finishPlayer = this.carRacingService.finishGame();

        int winScore = finishPlayer.getWinnerScore();
        output.printWinnerPlayer(finishPlayer.getWinnerPlayer(winScore));
    }
}