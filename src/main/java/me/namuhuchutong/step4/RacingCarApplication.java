package me.namuhuchutong.step4;

import me.namuhuchutong.step4.controller.RacingCar;
import me.namuhuchutong.step4.domain.RacingCarService;
import me.namuhuchutong.step4.domain.rule.RandomRacingRule;
import me.namuhuchutong.step4.view.InputView;
import me.namuhuchutong.step4.view.OutputView;

public class RacingCarApplication {

    public static void main(String[] args){
        RacingCar racingCar = new RacingCar(
                new InputView(), new OutputView(), new RacingCarService(new RandomRacingRule()));
        racingCar.start();
    }
}
