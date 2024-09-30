package race;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WorldRallyChampionship {
    private InputView inputView = new InputView();
    private RacingCarGame racingCarGame = new RacingCarGame();

    public static void main(String[] args) {
        WorldRallyChampionship wrc = new WorldRallyChampionship();
        wrc.openWordRallyChampionShip();
    }

    public void openWordRallyChampionShip() {
        readyCarRacing();
        racingCarGame.startRace();
        closeRace();
    }

    private void closeRace() {
        inputView.closeScanner();
    }

    private void readyCarRacing() {
        List<String> carNames = this.inputView.receiveCarNames();
        racingCarGame.setRacingCars(carNames);
        int raceCount = inputView.receiveRaceCount();
        racingCarGame.setRaceCount(raceCount);
    }
}
