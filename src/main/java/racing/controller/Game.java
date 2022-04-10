package racing.controller;

import racing.domain.NumberOfCars;
import racing.domain.NumberOfRound;
import racing.ui.InputView;

public class Game {

    public static void main(String[] args) {
        final NumberOfCars numberOfCars = InputView.inputNumberOfCars();
        final NumberOfRound numberOfRound = InputView.inputNumberOfRound();
    }
}
