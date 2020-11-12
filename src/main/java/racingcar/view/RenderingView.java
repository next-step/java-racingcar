package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class RenderingView {

    private static final String RACEGAME_MOVE_OUTPUT_EXPRESSION = "-";
    private static final String WINNER_POSTFIX_EXPRESSION = ",";

    public RenderingView(int participantCar, String[] carNames) {
        System.out.println("실행결과");
        readyForStart(participantCar, carNames);
    }

    public void renderResult(RacingCars racingCars) {
        List<Integer> result = racingCars.getResult();
        for (int i = 0; i < result.size(); i++) {
            System.out.print(racingCars.getCarName().get(i) + ": ");
            System.out.println(String.join("", Collections.nCopies(result.get(i), RACEGAME_MOVE_OUTPUT_EXPRESSION)));
        }
        System.out.println("");
    }

    public void renderWinner(RacingCars racingCars) {
        List<RacingCar> winners = racingCars.getWinner();
        String renderWinner = parseWinnerToString(winners);

        System.out.println(renderWinner + "가 우승했습니다.");
    }

    private String parseWinnerToString(List<RacingCar> winners) {
       return winners.stream()
                .map(racingCar -> racingCar.getCarName())
                .collect(joining(WINNER_POSTFIX_EXPRESSION));
    }


    private void readyForStart(int participantCar, String[] carNames) {
        for (int i = 0; i < participantCar; i++) {
            System.out.print(carNames[i] + ": ");
            System.out.println(RACEGAME_MOVE_OUTPUT_EXPRESSION);
        }
        System.out.println("");
    }

}
