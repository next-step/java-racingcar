package step4_winner;

import step4_winner.view.InputView;
import step4_winner.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRacingWinner {
    public static void main(String[] args) {
        // init
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        ResultView resultView = new ResultView();

        // input
        String carNamesWithComma= inputView.getCarNamesWithComma();
        int numberOfTries = inputView.getNumberOfRounds();

        String[] carNames = carNamesWithComma.split(",");

        List<Car> cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());

        Race race = new Race(cars);


        // result
        runRaces(numberOfTries, race, cars,resultView);
    }

    private static void runRaces(int numberOfRounds,
                                 Race race, List<Car> cars,
                                 ResultView resultView) {
        resultView.printResultHeader();
        for(int i = 0; i < numberOfRounds; i++) {
            race.runRound();
            resultView.displayRaceResult(cars);
        }
        resultView.printFinalWinner(cars);
    }
}
