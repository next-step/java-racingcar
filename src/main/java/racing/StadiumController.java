package racing;

import racing.domain.Stadium;
import racing.view.CarRacingConsoleView;

public class StadiumController {

    public static void main(String[] args) {

        CarRacingConsoleView view = new CarRacingConsoleView();

        String carNames = view.inputCarNames();
        int round = view.inputRound();

        Stadium stadium = new Stadium(carNames, round);

        view.beforeRacing();
        while(!stadium.isRacingEnd()){
            view.showRacing(stadium.racingCars());
        }

        view.showWinners(stadium.getWinner());


    }

}
