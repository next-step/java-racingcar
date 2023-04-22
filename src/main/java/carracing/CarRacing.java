package carracing;

import carracing.model.Match;
import carracing.model.Racer;
import carracing.present.InputPresent;
import carracing.present.OutputPresent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        InputPresent inputPresent = new InputPresent();
        OutputPresent outputPresent = new OutputPresent();

        List<String> participates = inputPresent.participates();
        int iteration = inputPresent.iteration();
        Match match = matchUp(participates, iteration);

        outputPresent.printResult(match.progressDisplay());
        outputPresent.printWinner(match.winnerDisplay());
    }

    private static Match matchUp(List<String> participates, int iteration) {
        Match match = new Match();
        for (String carName : participates) {
            match.addRacer(new Racer(carName, randomScores(iteration)));
        }
        return match;
    }

    private static List<Integer> randomScores(int iteration) {
        List<Integer> scoreList = new ArrayList<>();
        for (int i = 0; i < iteration; i++) {
            scoreList.add(RANDOM.nextInt(9));
        }
        return scoreList;
    }
}
