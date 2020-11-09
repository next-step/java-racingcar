package racingcar.view;

import racingcar.model.RaceGame;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class RenderingView {

    private static int executeCount;
    private static final String RACEGAME_MOVE_OUTPUT_EXPRESSION = "-";
    private static final String WINNER_POSTFIX_EXPRESSION = ",";

    public RenderingView(int participantCar, String[] carNames) {
        System.out.println("실행결과");
        readyForStart(participantCar, carNames);
    }

    public void renderView(RaceGame raceGame) {
        List<Integer> result = raceGame.getRoundResult();
        for (int i = 0; i < result.size(); i++) {
            System.out.print(raceGame.getCarNames().get(i) + ": ");
            System.out.println(String.join("", Collections.nCopies(result.get(i), RACEGAME_MOVE_OUTPUT_EXPRESSION)));
        }
        System.out.println("");
        executeCount++;
    }

    public void outPutWinner(RaceGame raceGame) {
        String winners = raceGame.getWinner().stream().collect(joining(WINNER_POSTFIX_EXPRESSION));
        System.out.print(winners + "가 우승했습니다.");
    }


    private void readyForStart(int participantCar, String[] carNames) {
        for (int i = 0; i < participantCar; i++) {
            System.out.print(carNames[i] + ": ");
            System.out.println(RACEGAME_MOVE_OUTPUT_EXPRESSION);
        }
        System.out.println("");
    }


    public int getExecuteCount() {
        return executeCount;
    }
}
