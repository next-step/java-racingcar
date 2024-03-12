package racingcar;


import racingcar.domain.CarRace;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class Main {

    public static void main(String[] args) {
        CarRace carRace = new CarRace(new InputView(), new ResultView());
        carRace.race();
    }

}
