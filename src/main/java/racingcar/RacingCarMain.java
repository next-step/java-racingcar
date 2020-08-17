package racingcar;

import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.ResultView;


public class RacingCarMain {
    public static void main(String[] args) {

        int carCounts = InputView.getCarCounts();
        int racingCounts = InputView.getRacingCounts();

        RacingCars racingCars = new RacingCars(carCounts, racingCounts);
        ResultView.printStartResult();
        while (racingCars.yesRacingCond( )) {
            racingCars.yesRacingCars( );

        ResultView.printCars(racingCars.getCars());
        ResultView.printLine();
        }
    }

}
