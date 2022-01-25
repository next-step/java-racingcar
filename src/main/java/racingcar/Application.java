package racingcar;

import java.util.List;
import racingcar.service.CarRace;
import racingcar.ui.RacingCarInput;

public class Application {

    public static void main(String[] args) {
        RacingCarInput racingCarInput = new RacingCarInput();
        List<String> carNameList = racingCarInput.getCarName();
        int raceCount = racingCarInput.getRaceCount();
        CarRace carRace = new CarRace(carNameList, raceCount);
        carRace.run();
    }
}
