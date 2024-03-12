package racingcar.controller;


import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class CarRaceApp {

    public static void main(String[] args) {
        CarRace carRace = new CarRace(new InputView(), new ResultView());
        carRace.race();
    }

}
