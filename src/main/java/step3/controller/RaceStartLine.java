package step3.controller;

import step3.model.Car;
import step3.model.Race;
import step3.model.RaceBoard;
import step3.view.RaceInputView;

import java.util.List;
import java.util.Scanner;

public class RaceStartLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cars = RaceInputView.carsInput(scanner);
        int times = RaceInputView.raceTimeInput(scanner);

        List<Car> carList = new RaceBoard(cars).generate();
        new Race(carList).playing(times);
    }
}
