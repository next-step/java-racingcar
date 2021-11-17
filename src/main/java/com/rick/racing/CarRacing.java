package com.rick.racing;

import com.rick.racing.controller.CarMovingDecider;
import com.rick.racing.controller.CarRacingController;
import com.rick.racing.controller.RandomCarMovingDecider;
import com.rick.racing.model.CarRacingInfo;
import com.rick.racing.ui.InputView;

public class CarRacing {

    public static void main(String[] args) {
        CarRacingInfo carRacingInfo = InputView.getCarRacingInfo();
        CarMovingDecider carMovingDecider = RandomCarMovingDecider.create();

        CarRacingController.create(carRacingInfo, carMovingDecider)
            .start();
    }
}
