package race;

import java.util.List;

public class WorldRallyChampionship {
    private InputView inputView = new InputView();
    private RacingCarGame racingCarGame;

    public static void main(String[] args) {
        WorldRallyChampionship wrc = new WorldRallyChampionship();
        wrc.openWordRallyChampionShip();
    }

    public void openWordRallyChampionShip() {
        readyCarRacing();
        racingCarGame.startRace();
        List<RacingCar> winners = racingCarGame.findWinners();
        racingCarGame.notifyChampionWinner(winners);
        closeRace();
    }

    private void closeRace() {
        inputView.closeScanner();
    }

    private void readyCarRacing() {
        List<String> carNames = this.inputView.receiveCarNames();
        int raceCount = inputView.receiveRaceCount();
        racingCarGame = new RacingCarGame(carNames, raceCount);
    }
}
