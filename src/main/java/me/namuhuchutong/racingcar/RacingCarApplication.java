package me.namuhuchutong.racingcar;

import me.namuhuchutong.racingcar.controller.RacingCar;
import me.namuhuchutong.racingcar.domain.RacingCarService;
import me.namuhuchutong.racingcar.domain.rule.RandomRacingRule;
import me.namuhuchutong.racingcar.view.InputView;
import me.namuhuchutong.racingcar.view.OutputView;

public class RacingCarApplication {

    public static void main(String[] args){
        RacingCar racingCar = new RacingCar(
                new InputView(), new OutputView(), new RacingCarService(new RandomRacingRule()));
        racingCar.start();
    }
}
