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
    }

    public void setRacingCars(int carCount) {
        this.racingCars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            this.racingCars.add(new RacingCar());
        }
    }

    private void startRace() {
        IntStream.range(0, raceCount).forEach(i -> racingCarGame.race(this.racingCars));
    }

    private void readyCarRacing() {
        int carCount = this.inputView.receiveCarCount();
        setRacingCars(carCount);
        this.raceCount = inputView.receiveRaceCount();
    }
}
