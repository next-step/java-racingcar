package step3.domain;

import step3.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

    private ResultView resultView = new ResultView();

    private JoinedCars joinedCars;
    private int totalTries;

    private RaceRoulette raceRoulette = RaceRoulette.simple(9);

    public CarRacing(String carNames, int numOfTries) {
        joinedCars = new JoinedCars(carNames);
        totalTries = numOfTries;
    }

    public void start() {
        int currentTry = 1;

        System.out.println("경주 시작");

        while (currentTry++ <= totalTries) {
            tryMovingAllCars();
            displayRaceState();
        }

        announceRaceWinner();
    }

    private void tryMovingAllCars() {
        joinedCars.tryMoving(raceRoulette);
    }

    private void displayRaceState() {
        resultView.showRaceState(joinedCars);
    }

    private void announceRaceWinner() {
        List<Car> winners = joinedCars.findRaceWinner(new RaceWinnerFinder());
        resultView.showRaceWinner(winners.stream().map(it -> CarState.of(it)).collect(Collectors.toList()));
    }

}
