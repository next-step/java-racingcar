package racing.web.view;

import racing.board.GameResult;
import racing.board.StepResult;
import racing.model.RacingCar;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    public static void viewWinners(Map<String, Object> model, GameResult gameResult) {
        model.put("winnerNames", gameResult.getWinners().stream().map(RacingCar::toString).collect(Collectors.joining(", ")));
    }

    public static void viewHistory(Map<String, Object> model, List<StepResult> history) {
        model.put("stepByStep", convertToStepByStepCarInfo(history));
    }

    private static List<Map<String, List<Integer>>> convertToStepByStepCarInfo(List<StepResult> history) {
        return history.stream()
                .map(ResultView::convertToCarInfo)
                .collect(Collectors.toList());
    }

    private static Map<String, List<Integer>> convertToCarInfo(StepResult stepResult) {
        return stepResult.getCars()
                .stream()
                .collect(collectCarInfo());
    }

    private static Collector<RacingCar, ?, Map<String, List<Integer>>> collectCarInfo() {
        return Collectors.toMap(
                (RacingCar car) -> car.toString(),
                ResultView::convertToRange);
    }

    private static List<Integer> convertToRange(RacingCar car) {
        return IntStream.range(0, car.getPosition())
                .boxed()
                .collect(Collectors.toList());
    }
}
