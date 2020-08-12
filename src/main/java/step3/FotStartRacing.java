package step3;

import step3.utility.InputView;
import step3.controller.CarRacing;
import step3.controller.UserInput;
import step3.utility.ResultView;

class FotStartRacing {
    public static void main(String[] args) {
        UserInput input = InputView.initShow();

        CarRacing race = new CarRacing(input.getnumOfCars(), input.getTries());
        race.gameStart();

        ResultView.resultShow(race.getCarRecord());
    }
}
