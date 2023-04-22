package step3;

import step3.model.Racer;
import step3.present.DisplayRaceVO;
import step3.present.InputPresent;
import step3.present.OutputPresent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        InputPresent inputPresent = new InputPresent();
        OutputPresent outputPresent = new OutputPresent();

        for (String carName : inputPresent.participates()) {
            Racer racer = new Racer(carName, randomScores(inputPresent.iteration()));
        }

        outputPresent.printResult(progressDisplay());
        outputPresent.printWinner(winnerDisplay());
    }

    private static List<Integer> randomScores(int iteration) {
        List<Integer> scoreList = new ArrayList<>();
        for(int i=0 ; i<iteration ; i++) {
            scoreList.add(RANDOM.nextInt(9));
        }
        return scoreList;
    }

    private static List<String> winnerDisplay() {
        throw new RuntimeException();
    }

    private static List<DisplayRaceVO> progressDisplay() {
        throw new RuntimeException();
    }
}
