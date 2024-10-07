package race.controller;

import race.domain.RacingCar;
import race.domain.RacingCarGame;
import race.model.RaceCount;
import race.view.InputView;
import race.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class WorldRallyChampionship {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private RacingCarGame racingCarGame;
    private RaceCount raceCount;

    public static void main(String[] args) {
        WorldRallyChampionship wrc = new WorldRallyChampionship();
        wrc.openWordRallyChampionShip();
    }

    public void openWordRallyChampionShip() {
        readyCarRacing();
        startRace();
        List<RacingCar> winners = racingCarGame.findWinners();
        resultView.printChampionWinner(winners);
        closeRace();
    }

    private void startRace() {
        while (raceCount.hasMoreRaces()) {
            List<RacingCar> racingCars = racingCarGame.race();
            raceCount.decrease();
            resultView.printRaceCondition(racingCars);
        }
    }
    private void closeRace() {
        inputView.closeScanner();
    }

    private void readyCarRacing() {
        List<String> carNames = inputView.receiveCarNames();
        this.raceCount = new RaceCount(inputView.receiveRaceCount());
        List<RacingCar> racingCars = generateRacingCars(carNames);
        this.racingCarGame = new RacingCarGame(racingCars);
        resultView.printRaceStartMessage();
    }

    private List<RacingCar> generateRacingCars(List<String> carNames) {
        return carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }
}
