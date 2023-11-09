package com.racing;

import com.racing.game.entity.CarRace;
import com.racing.game.RaceStorage;
import com.racing.game.viewmodel.InputViewModel;
import com.racing.game.viewmodel.ResultViewModel;

public class JavaRacingCarApplication {
    public static void main(String[] args) {
        RaceStorage raceStorage = new RaceStorage();
        RacingController racingController = new RacingController(new InputViewModel(raceStorage), new ResultViewModel(raceStorage), new CarRace(raceStorage));
        racingController.startRace();
    }
}
