package step4.controller;

import step4.model.Car;
import step4.model.Race;
import step4.model.RaceBoard;
import step4.model.Winner;
import step4.view.RaceWinnerInputView;
import step4.view.RaceWinnerOutputView;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RacingController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> carNames = RaceWinnerInputView.driverInput(scanner);
        int times = RaceWinnerInputView.raceTimeInput(scanner);

        List<Car> cars = new RaceBoard(carNames).generate();
        IntStream.range(0, times).forEach(t -> {
            new Race(cars).start();
            new RaceWinnerOutputView(cars).progressInGame();
        });

        List<Car> winners = new Winner(cars).get();
        new RaceWinnerOutputView(winners).winner();
    }
}
