package com.racing;

import com.racing.game.entity.Circuit;
import com.racing.game.viewmodel.InputViewModel;
import com.racing.game.viewmodel.ResultViewModel;

public class JavaRacingCarApplication {
    public static void main(String[] args) {
        Circuit circuit = new Circuit();
        RacingController racingController = new RacingController(new InputViewModel(circuit), new ResultViewModel(
                circuit), circuit);
        racingController.startRace();
    }
}
