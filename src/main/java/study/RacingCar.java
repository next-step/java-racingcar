package study;

import study.utils.ArrayListUtils;
import study.utils.RandomUtils;
import study.view.InputView;
import study.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private int numberOfCar;
    private int numberOfMoves;
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void startRacer() {
        setNumberOfCars();
        setNumberOfMoves();
        playRacerAndPrintOneRacingResult();
    }

    private void setNumberOfCars() {
        numberOfCar = inputView.setNumberOfCars();
    }

    private void setNumberOfMoves() {
        numberOfMoves = inputView.setNumberOfMoves();
    }

    private void playRacerAndPrintOneRacingResult() {
        resultView.beforeRacingPrintMessage();

        ArrayList<String>[] raceList = ArrayListUtils.get2ArrayList(numberOfCar);

        for (int i = 0; i < numberOfMoves; i++) {
            goOrStopCar(raceList);
            resultView.printOneRacingResult(raceList);
        }
    }

    private void goOrStopCar(ArrayList<String>[] raceList) {
        for (List<String> car : raceList) {
            if (canMovingCar()) {
                car.add("-");
            }
        }
    }

    private boolean canMovingCar() {
        if (RandomUtils.getRandomBetween0To9Number() >= 4) {
            return true;
        }
        return false;
    }
}
