package com.racing;

import com.racing.game.viewmodel.InputViewModel;
import com.racing.game.viewmodel.ResultViewModel;

public class JavaRacingCarApplication {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(new InputViewModel(), new ResultViewModel());
        racingController.startRace();
    }
}
