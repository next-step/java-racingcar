package step4;

import step4.domain.CarRace;
import step4.domain.Cars;
import step4.view.InputView;
import step4.view.OutputView;

public class CarRaceApplication {

    private static CarRace carRace;

    public static void main(String[] args) {
        final String inputCarNames = InputView.getCarNames();
        final int numberOfTrials = InputView.getNumberOfTrials();

        carRace = CarRace.raceStart(inputCarNames, numberOfTrials);

        OutputView.showResultTitle();
        for (int i = 0; i < numberOfTrials; i++) { //TODO: 모델에 위임하고 VO리턴받아서 OutputView에 전달
            Cars raceResult = carRace.executeTrials();
            OutputView.showResult(raceResult);
        }
        OutputView.printWinners(carRace.pickWinners());
    }

}
