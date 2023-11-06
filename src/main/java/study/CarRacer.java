package study;

import study.view.InputView;
import study.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacer {

    private int numberOfCar;
    private int numberOfMoves;
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();
    Random random = new Random();

    public void startRacer() {
        setNumberOfCars();
        setNumberOfMoves();
        resultView.beforeRacingPrintMessage();
        playRacerAndPrintOneRacingResult();
    }

    private void setNumberOfCars() {
        numberOfCar = inputView.setNumberOfCars();
    }

    private void setNumberOfMoves() {
        numberOfMoves = inputView.setNumberOfMoves();
    }

    private void playRacerAndPrintOneRacingResult() {
        ArrayList<String>[] raceList = getRaceArrayList();
        int randomNumber = 0;

        for (int i = 0; i < numberOfMoves; i++) {
            for (List<String> car : raceList) {
                randomNumber = getRandomBetween0To9Number();
                if (randomNumber >= 4) {
                    car.add("-");
                }
            }
            resultView.printOneRacingResult(raceList);
        }
    }

    private ArrayList<String>[] getRaceArrayList() {
        ArrayList<String>[] raceList = new ArrayList[numberOfCar];

        for (int i = 0; i < numberOfCar; i++) {
            raceList[i] = new ArrayList<String>();
        }
        return raceList;
    }

    private int getRandomBetween0To9Number() {
        return random.nextInt(10);
    }

}
