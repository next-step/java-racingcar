package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.service.CarsService;
import racingcar.service.impl.CarsServiceImpl;
import racingcar.view.InputView;

public class RacingCarApplication {
    public static void main(String[] args){
        CarsService carsService = new CarsServiceImpl(new InputView());
        RacingCarGame racingCarGame = new RacingCarGame(carsService);
        racingCarGame.run();

    }

}
