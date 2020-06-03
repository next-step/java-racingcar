package step3.controller;

import step3.model.*;
import step3.view.InputView;
import step3.view.ResultView;

public class RaceGame {

    public static void main(String[] args) {
        Integer numberOfCars = InputView.getNumberOfCars();
        Integer numberOfRounds = InputView.getNumberOfRounds();

        Cars cars = new Cars(numberOfCars);
        Round rounds = new Round(numberOfRounds);
        Race race = new Race(cars, rounds);


        ResultView.start();
        race.start();
    }
}
