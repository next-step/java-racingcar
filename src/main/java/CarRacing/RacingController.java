package CarRacing;

import CarRacing.domain.Competition;
import CarRacing.view.InputView;
import CarRacing.view.ResultView;

public class RacingController {

    private static final int DISTANCE_PER_TRY = 1;

    public static void start() {
        String[] nameOfCars = InputView.getCars();
        int numberOfTry = InputView.getNumberOfTry();

        Competition competition = new Competition();
        try {
            competition.entry(nameOfCars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }

        for (int idxTry = 0; idxTry < numberOfTry; idxTry++) {
            ResultView.printCurrentDistance(competition.moveCars(DISTANCE_PER_TRY));
        }

        ResultView.printWinners(competition.winners());
    }


}

