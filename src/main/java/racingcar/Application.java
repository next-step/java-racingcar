package racingcar;


import java.util.List;
import racingcar.service.carRace;
import racingcar.ui.RacingCarInput;

public class Application {

    public static void main(String[] args) {
        RacingCarInput racingCarInput = new RacingCarInput();
        List<String> carNameList = racingCarInput.getCarName();
        int raceCount = racingCarInput.getRaceCount();
        carRace carRace = new carRace(carNameList);
        while (0 < raceCount) {
            carRace.moveForwardAll();
            carRace.printRacing();
            raceCount--;
            System.out.println("------------------------------");
        }
        carRace.printWinner();
    }
}
