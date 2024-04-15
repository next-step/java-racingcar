package step3_CarRacing;

import step3_CarRacing.view.InputView;
import step3_CarRacing.view.ResultView;

import java.util.Scanner;

public class CarRacingGame {
    public static void main(String[] args) {
        //init
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        ResultView resultView = new ResultView();

        //input
        int numberOfCars = inputView.getNumberOfCars();
        Race race = new Race(numberOfCars);
        int numberOfRounds = inputView.getNumberOfRounds();

        //result
        runRaces(numberOfRounds, race, resultView);
    }

    private static void runRaces(int numberOfRounds, Race race, ResultView resultView) {
        resultView.printResultHeader();
        for (int i = 0; i < numberOfRounds; i++) {
            race.runRound();
            resultView.displayRaceResult(race.getCars());
        }
    }
}
