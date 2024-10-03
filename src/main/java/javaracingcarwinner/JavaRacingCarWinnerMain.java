package javaracingcarwinner;

import javaracingcarwinner.controller.JavaRacingCar;
import javaracingcarwinner.entity.RacingCar;
import javaracingcarwinner.view.InputView;
import javaracingcarwinner.view.ResultView;

public class JavaRacingCarWinnerMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        JavaRacingCar javaRacingCar = new JavaRacingCar(inputView.info(), resultView);
    }
}
