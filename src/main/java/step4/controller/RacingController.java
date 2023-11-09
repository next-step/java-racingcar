package step4.controller;

import step4.model.Car;
import step4.model.Races;
import step4.model.Winners;
import step4.view.RaceWinnerInputView;
import step4.view.RaceWinnerOutputView;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RacingController {

    private static final int MAX_RANDOM_VALUE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> carNames = RaceWinnerInputView.carNameInput(scanner);
        int times = RaceWinnerInputView.raceTimeInput(scanner);

        Races races = new Races(carNames);
        IntStream.range(0, times).forEach(t -> {
            races.start(new Random().nextInt(MAX_RANDOM_VALUE));
            new RaceWinnerOutputView(races.getCars()).progressInGame();
        });

        List<Car> winners = new Winners(races.getCars()).get();
        new RaceWinnerOutputView(winners).winner();
    }
}
