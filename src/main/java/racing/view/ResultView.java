package racing.view;

import racing.board.GameResult;
import racing.board.StepResult;
import racing.model.RacingCar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String CHAR_TO_CONVERT = "-";

    public static void viewGameStart() {
        System.out.println("\n실행 결과");
    }

    public static void viewWinners(GameResult gameResult) {
        System.out.printf("%s가 최종 우승했습니다.\n ", gameResult.getWinners()
                .stream()
                .map(RacingCar::toString)
                .collect(Collectors.joining(", ")));
    }

    public static void viewHistory(List<StepResult> history) {
        for (StepResult stepResult : history) {
            viewRunningStep(stepResult.getCars());
            System.out.println();
        }
    }

    private static void viewRunningStep(List<RacingCar> stepCars) {
        System.out.println(stepCars.stream()
                .map(car -> car.toString() + " : " + convertToHyphens(car.getPosition()))
                .collect(Collectors.joining("\n")));
    }

    public static String convertToHyphens(int position) {
        return IntStream.range(0, position)
                .mapToObj(p -> CHAR_TO_CONVERT)
                .collect(Collectors.joining());
    }
}
