package racing.main;

import racing.domain.Competition;
import racing.domain.RandomMovement;
import racing.ui.InputView;
import racing.ui.ResultView;

public class Controller {
    public static void main(String[] args) {
        int unit = InputView.inputNumberOfCars();
        int round = InputView.inputNumberOfRounds();

        Competition competition = new Competition(unit, round, new RandomMovement());
        ResultView.print(competition.progressEachRound());
        System.out.println();
        ResultView.print(competition.progressEachRound());
        System.out.println();
        ResultView.print(competition.progressEachRound());
        System.out.println();
        ResultView.print(competition.progressEachRound());
        System.out.println();
        ResultView.print(competition.progressEachRound());
    }
}
