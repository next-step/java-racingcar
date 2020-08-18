package step5;

import step5.model.Cars;
import step5.utility.InputView;
import step5.controller.CarRacing;
import step5.controller.UserInput;
import step5.utility.ResultView;

class FotStartRacing {
    public static void main(String[] args) {
        UserInput input = InputView.initShow();

        CarRacing race = new CarRacing(input.getUserInputForCarName()
                            , input.getTries());
        Cars cars = race.gameStart();

        ResultView.resultShow(cars, input.getTries());
    }
}
