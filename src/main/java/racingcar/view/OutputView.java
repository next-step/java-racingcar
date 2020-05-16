package racingcar.view;

import racingcar.vo.car.CarMoveResult;
import racingcar.domain.game.GameResult;
import racingcar.domain.game.PhaseResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String MARK = "-";
    private static final String WINNER_JOINING_DELIMETER = ",";

    private OutputView() {
    }

    public static void printGameResult(GameResult gameResult) {
        System.out.println("실행 결과");

        gameResult.getPhaseResults().stream()
                .forEach(OutputView::printPhaseResult);

        printWinners(gameResult.findWinners());
    }

    public static void printWinners(List<String> winners) {
        String winner = winners.stream()
                .collect(Collectors.joining(WINNER_JOINING_DELIMETER));

        System.out.println(winner + "가 최종 우승했습니다.");
    }

    public static void printPhaseResult(PhaseResult phaseResult) {
        phaseResult.getRaceResult().stream()
                .map(OutputView::mappingNameAndLocation)
                .forEach(System.out::println);
    }

    private static String mappingNameAndLocation(CarMoveResult carMoveResult) {
        return carMoveResult.getName() + " : " + visualizeLocation(carMoveResult.getLocation());
    }

    private static String visualizeLocation(int location) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < location; i++) {
            builder.append(MARK);
        }

        return builder.toString();
    }
}
