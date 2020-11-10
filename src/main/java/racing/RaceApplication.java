package racing;

import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.List;

public class RaceApplication {

    public static void main(String[] args) {
        int participationCars = InputView.inputParticipationCars();
        int numberOfParticipationTry = InputView.inputNumberOfTry();

        Cars cars = new Cars(participationCars);
        ResultView.output(numberOfParticipationTry, cars);
    }
}
