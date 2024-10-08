package race.controller;

import race.domain.RacingCar;
import race.domain.RacingCarGame;
import race.domain.RandomMoveStrategy;
import race.model.RaceResult;
import race.model.CarName;
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
        celebrateWinners();
        closeRace();
    }

    private void celebrateWinners() {
        List<CarName> winnersName = racingCarGame.findWinnersName();
        resultView.printChampionWinner(winnersName);
    }

    private void startRace() {
        resultView.printRaceStartMessage();
        while (raceCount.hasMoreRaces()) {
            RaceResult raceResult = racingCarGame.race();
            raceCount.decrease();
            resultView.printRaceResult(raceResult);
        }
    }

    private void readyCarRacing() {
        List<String> carNames = inputView.receiveCarNames();
        this.raceCount = new RaceCount(inputView.receiveRaceCount());
        List<RacingCar> racingCars = generateRacingCars(carNames);
        this.racingCarGame = new RacingCarGame(racingCars, new RandomMoveStrategy());
    }

    private List<RacingCar> generateRacingCars(List<String> carNames) {
        return carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    private void closeRace() {
        inputView.closeScanner();
    }
}
