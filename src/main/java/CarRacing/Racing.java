package CarRacing;

import CarRacing.domain.Competition;
import CarRacing.view.InputView;
import CarRacing.view.ResultView;

import static java.lang.System.exit;

public class Racing {

    public static void start() {
        String[] nameOfCars = InputView.getCars();
        int numberOfTry = InputView.getNumberOfTry();

        Competition competition = new Competition();
        try {
            competition.entry(nameOfCars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            exit(0);
        }

        for (int idxTry=0; idxTry < numberOfTry; idxTry++) {
            ResultView.printCurrentDistance(competition.moveCars());
        }

        ResultView.printWinners(competition.winners());
    }


}

