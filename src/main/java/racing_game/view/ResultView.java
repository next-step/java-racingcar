package racing_game.view;

import racing_game.model.GameResult;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ResultView {

    private static final String BLANK = "";
    private static final String EXECUTE_RESULT_MESSAGE = "실행 결과";
    private static final BinaryOperator<String> COMBINE = (left, right) -> left + " : " + right;
    private static final BinaryOperator<String> NEW_LINE = (before, after) -> before += ("\n" + after);

    private ResultView() {
    }

    public static void printMessage(String dialogue) {
        System.out.println(dialogue);
    }

    public static void printResult(GameResult gameResult) {
        printMessage(EXECUTE_RESULT_MESSAGE);
        combinedResult(gameResult);
        findWinner(gameResult);
    }

    private static void combinedResult(GameResult gameResult) {
        gameResult.getGameResult().forEach(result -> {
            AtomicReference<String> thisRoundResult = new AtomicReference<>(BLANK);
            result.forEach((name, forward) -> thisRoundResult.getAndAccumulate(COMBINE.apply(name, forward), NEW_LINE));
            printMessage(thisRoundResult.get());
        });
    }

    private static void findWinner(GameResult gameResult) {
        int finalRoundNumber = gameResult.getGameResult().size() - 1;
        String winner = gameResult.getGameResult().get(finalRoundNumber)
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByKey())
                .orElseThrow()
                .getKey();
        printMessage("\n" + winner);
    }
}
