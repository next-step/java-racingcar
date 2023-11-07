package com.racing;

import com.racing.game.viewmodel.InputViewModel;

public class JavaRacingCarApplication {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(new InputViewModel());
        racingController.startRace();
    }
}
