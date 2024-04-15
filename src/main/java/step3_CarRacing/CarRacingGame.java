package step3_CarRacing;

import step3_CarRacing.view.InputView;
import step3_CarRacing.view.ResultView;

import java.util.Scanner;

public class CarRacingGame {
    // TODO : 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
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
