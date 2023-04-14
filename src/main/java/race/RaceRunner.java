package race;

import java.util.List;
import java.util.Scanner;
import race.domain.Race;
import race.domain.Winner;
import race.util.Split;
import race.view.InputView;
import race.view.ResultView;

public class RaceRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String carName = inputCarName(scanner, inputView);
        int countOfTrial = inputCountOfTrial(scanner, inputView);

        resultView.printResultComment();

        Race race = new Race(Split.getNames(carName), countOfTrial);
        race.start();

        Winner winner = new Winner();
        List<String> winners = winner.get(race.getRacingCars());
        resultView.printWinners(winners);
    }

    private static int inputCountOfTrial(Scanner scanner, InputView inputView) {
        inputView.countOfTrialComment();
        return scanner.nextInt();
    }

    private static String inputCarName(Scanner scanner, InputView inputView) {
        inputView.carNameComment();
        return scanner.nextLine();
    }
}
