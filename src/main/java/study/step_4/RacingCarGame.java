package study.step_4;

import study.step_4.service.RacingCar;
import study.step_4.ui.InputView;
import study.step_4.ui.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RacingCarGame {

    private final int DEFAULT_DISTANCE = 0;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<RacingCar> setUpRacingCar(String[] numberOfCars) {
        ArrayList<RacingCar> garage = new ArrayList<>();
        for (String numberOfCar : numberOfCars) {
            garage.add(new RacingCar(numberOfCar, DEFAULT_DISTANCE));
        }
        return garage;
    }

    public void gamePlay() {
        String[] numberOfCars = inputView.welcomeMessage();
        int attempt = inputView.askAttemptMessage();

        int playCars = numberOfCars.length;
        List<RacingCar> garage = setUpRacingCar(numberOfCars);
        startGame(attempt, playCars, garage);
        award(garage);
    }

    private void startGame(int attempt, int numberOfCars, List<RacingCar> garage) {
        outputView.endGameMessage();

        for (int i = 0; i < attempt; i++) {
            startRacing(numberOfCars, garage);
            System.out.println();
        }
    }

    private void startRacing(int numberOfCars, List<RacingCar> garage) {
        for (int j = 0; j < numberOfCars; j++) {
            racingCarMoving(garage, j);
        }
    }

    private void racingCarMoving(List<RacingCar> garage, int numberOfCar) {
        RacingCar racingCar = garage.get(numberOfCar);
        int distance = racingCar.drive(10, 4);
        String name = racingCar.getName();

        if ((distance > 0)) {
            outputView.SkidMark(name, distance);
        }
        outputView.cantDrive(name, distance);
    }

    public void award(List<RacingCar> garage) {
        outputView.winnerAwards(findWinners(garage));
    }

    public List<String> findWinners(List<RacingCar> list) {
        Collections.sort(list, Comparator.comparingInt(RacingCar::getDistance));

        int maxDistance = list.get(list.size() - 1).getDistance();
        List<String> winners = new ArrayList<>();

        for (RacingCar car : list) {
            sameWinnder(car, maxDistance, winners);
        }
        return winners;
    }

    private static void sameWinnder(RacingCar car, int maxDistance, List<String> winners) {
        if (car.getDistance() == maxDistance) {
            winners.add(car.getName());
        }
    }

    public static void main(String[] args) {
        RacingCarGame game = new RacingCarGame(new InputView(), new OutputView());
        game.gamePlay();
    }
}
