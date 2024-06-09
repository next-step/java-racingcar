package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.service.cars.CarsService;
import racingcar.service.cars.impl.CarsServiceImpl;
import racingcar.service.race.RaceService;
import racingcar.service.race.impl.RaceServiceImpl;
import racingcar.view.InputView;

public class RacingCarApplication {
    public static void main(String[] args){
        CarsService carsService = new CarsServiceImpl(new InputView());
        RaceService raceService = new RaceServiceImpl(new InputView());
        RacingCarGame racingCarGame = new RacingCarGame(carsService, raceService);
        racingCarGame.run();

    }

}
