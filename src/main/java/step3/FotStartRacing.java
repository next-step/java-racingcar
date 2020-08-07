package step3;

import step3.view.InputView;
import step3.controller.CarRacing;

class FotStartRacing{
    public static void main(String[] args) {
        InputView.initShow();

        CarRacing race =  new CarRacing(InputView.cars,InputView.tries);
        race.gameStart();
    }
}
