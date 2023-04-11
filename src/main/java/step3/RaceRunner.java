package step3;

import java.util.Scanner;
import step3.view.InputView;
import step3.view.ResultView;

public class RaceRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int countOfCar = inputCountOfCar(scanner, inputView);
        int countOfTrial = inputCountOfTrial(scanner, inputView);

        resultView.printResultComment();

        Race race = new Race(countOfCar, countOfTrial);
        race.start();
    }

    private static int inputCountOfTrial(Scanner scanner, InputView inputView) {
        inputView.countOfTrialComment();
        return scanner.nextInt();
    }

    private static int inputCountOfCar(Scanner scanner, InputView inputView) {
        inputView.countOfCarComment();
        return scanner.nextInt();
    }
}
