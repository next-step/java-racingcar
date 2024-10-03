package javaracingcarwinner;

import javaracingcarwinner.controller.JavaRacingCar;
import javaracingcarwinner.entity.RacingCar;
import javaracingcarwinner.view.InputView;

public class JavaRacingCarWinnerMain {
    public static void main(String[] args){
        InputView inputView = new InputView();
        JavaRacingCar javaRacingCar = new JavaRacingCar(inputView.info());
    }
}
