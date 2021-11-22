package com.rick.racing;

import com.rick.racing.controller.CarMovingStrategy;
import com.rick.racing.controller.CarRacingController;
import com.rick.racing.controller.RandomCarMovingStrategy;
import com.rick.racing.model.CarRacingInfo;
import com.rick.racing.ui.InputView;

public class CarRacing {

    public static void main(String[] args) {
        CarRacingInfo carRacingInfo = InputView.getCarRacingInfo();
        CarMovingStrategy carMovingStrategy = RandomCarMovingStrategy.create();

        CarRacingController.create(carRacingInfo, carMovingStrategy)
            .start();
    }
}
