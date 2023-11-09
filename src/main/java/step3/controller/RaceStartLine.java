package step3.controller;

import step3.model.Car;
import step3.model.Race;
import step3.model.RaceBoard;
import step3.view.RaceInputView;
import step3.view.RaceResultView;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RaceStartLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cars = RaceInputView.carsInput(scanner);
        int times = RaceInputView.raceTimeInput(scanner);

        List<Car> carList = new RaceBoard(cars).generate();
        IntStream.range(0, times).forEach(t -> {
            new Race(carList).playing(Race.getRandomValue());
            new RaceResultView(carList).show();
        });
    }
}
