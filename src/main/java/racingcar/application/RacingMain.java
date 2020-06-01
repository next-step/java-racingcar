package racingcar.application;

import racingcar.view.ResultView;


public class RacingMain {
    public static void main(String[] args) {
//        int carNum = InputView.carNum();
//        int tryNum = InputView.tryTime();

//        Racing racing = new Racing(carNum, tryNum);
        Racing racing = new Racing("pobi,crong,honux", 4);

        ResultView.results(racing.getRacingCars(), racing.startRace());
    }
}
