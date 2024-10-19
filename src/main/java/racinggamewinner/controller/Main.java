package racinggamewinner.controller;

import racinggamewinner.domain.Cars;
import racinggamewinner.random.NumberGenerateStrategy;
import racinggamewinner.random.NumberGenerator;
import racinggamewinner.random.RacingCarRandomNumber;
import racinggamewinner.view.InputView;
import racinggamewinner.view.ResultView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String carNames = InputView.nameOfCars(scanner);
        int maxMovingCount = InputView.movingTryCount(scanner);

        Cars racingCars = Cars.registerCars(carNames);
        ResultView.printPreview();
        NumberGenerator numberGenerateStrategy = new NumberGenerateStrategy(new RacingCarRandomNumber());

        for (int i = 0; i < maxMovingCount; i++) {
            racingCars.raceOneRound(numberGenerateStrategy);
            ResultView.printTotalCarPosition(racingCars.carNameAndPositions());
        }
        
        ResultView.printWinner(racingCars.findWinner());

    }
}
