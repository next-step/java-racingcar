package step3;

import step3.view.InputView;
import step3.view.ResultView;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        RacingEvent racingEvent = new RacingEvent(inputView.getCarCount(), inputView.getTryCount());

        ResultView resultView = new ResultView();

        for(int i = 1; i <= inputView.getTryCount(); i++){
            for(Car car : racingEvent.getCarList()){
               resultView.showPositionHistory(car.getPositionHistory().get(i));
            }
            System.out.println("");
            System.out.println("");
        }

    }
}