package step4.controller;

import step4.model.Races;
import step4.model.RandomMoveStrategy;
import step4.view.RaceWinnerInputView;
import step4.view.RaceWinnerOutputView;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RacingController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> carNames = RaceWinnerInputView.carNameInput(scanner);
        int times = RaceWinnerInputView.raceTimeInput(scanner);

        Races races = new Races(carNames);
        IntStream.range(0, times).forEach(t -> {
            races.start(new RandomMoveStrategy());
            new RaceWinnerOutputView(races.getCars()).progressInGame();
        });

        new RaceWinnerOutputView(races.getWinners()).winner();
    }
}
