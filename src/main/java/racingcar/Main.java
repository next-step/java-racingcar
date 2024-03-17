package racingcar;


import racingcar.domain.CarRace;
import racingcar.domain.CarRaceResult;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class Main {

    public static void main(String[] args) {
        String nameString = InputView.readCarNameString();
        int tryCount = InputView.readHowManyTrys();

        CarRace carRace = new CarRace();
        CarRaceResult carRaceResult = carRace.race(nameString, tryCount);

        ResultView.printCarRaceResult(carRaceResult);
    }

}
