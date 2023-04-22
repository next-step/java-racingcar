package step3;

import step3.present.InputPresent;
import step3.present.OutputPresent;

public class CarRacing {
    public static void main(String[] args) {
        InputPresent inputPresent = new InputPresent();
        OutputPresent outputPresent = new OutputPresent();
        Match match = new Match(inputPresent.participates(), inputPresent.iterations());
        outputPresent.printResult(match.progressDisplay());
        outputPresent.printWinner(match.winnerDisplay());
    }
}
