package fourstep.logic;


import fourstep.view.InputView;
import fourstep.view.ResultView;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        int raceCount = InputView.inputRaceCount();
        String[] carNames = InputView.inputCarName();

        RandomNumber randomNumber = new RandomNumber();

        Race race = new Race(carNames, raceCount);

        ArrayList<String> winners = race.play(randomNumber);

        ResultView.printResultLine();
        ResultView.printEntireRace(race);
        ResultView.printWinner(winners);
    }

}
