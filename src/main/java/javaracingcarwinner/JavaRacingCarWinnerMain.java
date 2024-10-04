package javaracingcarwinner;

import javaracingcarwinner.controller.JavaRacingCar;
import javaracingcarwinner.view.InputView;
import javaracingcarwinner.view.ResultView;

public class JavaRacingCarWinnerMain {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        JavaRacingCar javaRacingCar = new JavaRacingCar(InputView.gameSettings(), resultView);
    }
}
