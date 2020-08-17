package step4;

import step4.model.Cars;
import step4.utility.InputView;
import step4.controller.CarRacing;
import step4.controller.UserInput;
import step4.utility.ResultView;

class FotStartRacing {
    public static void main(String[] args) {
        UserInput input = InputView.initShow();

        CarRacing race = new CarRacing(input.getCars(), input.getTries());
        Cars cars = race.gameStart();

        ResultView.resultShow(cars, input.getTries());
    }
}
