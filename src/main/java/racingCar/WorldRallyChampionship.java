package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WorldRallyChampionship {
    private InputView inputView = new InputView();
    private RacingCarGame racingCarGame = new RacingCarGame();
    private List<RacingCar> racingCars;
    private int raceCount = 0;

    public static void main(String[] args) {
        WorldRallyChampionship wrc = new WorldRallyChampionship();
        wrc.openWordRallyChampionShip();
    }

    public void openWordRallyChampionShip() {
        readyCarRacing();
        startRace();
        closeRace();
    }

    private void closeRace() {
        inputView.closeScanner();
    }
    public void setRacingCars(List<String> carNames) {
        this.racingCars = new ArrayList<>(carNames.size());
        for (int i = 0; i < carNames.size(); i++) {
            this.racingCars.add(new RacingCar(carNames.get(i)));
        }
    }

    private void startRace() {
        IntStream.range(0, raceCount).forEach(i -> racingCarGame.race(this.racingCars));
    }

    private void readyCarRacing() {
        List<String> carNames = this.inputView.receiveCarNames();
        setRacingCars(carNames);
        this.raceCount = inputView.receiveRaceCount();
    }
}
