package javaracingcar;

import javaracingcar.controller.JavaRacingCar;
import javaracingcar.view.InputView;

public class GameMain {
    public static void main(String[] args) {
        new JavaRacingCar(InputView.requireCarCount(), InputView.requireTryCount());
    }
}
