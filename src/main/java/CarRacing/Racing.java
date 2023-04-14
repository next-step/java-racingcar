package CarRacing;

import CarRacing.view.InputView;
import CarRacing.view.ResultView;

public class Racing {

    public static void start() {
        String[] nameOfCars = InputView.getCars();
        int numberOfTry = InputView.getNumberOfTry();

        Competition competition = new Competition();
        competition.entry(nameOfCars);

        for (int idxTry=0; idxTry < numberOfTry; idxTry++) {
            ResultView.printCurrentDistance(competition.moveCars());
        }

        ResultView.printWinners(competition.winners());
    }


}

