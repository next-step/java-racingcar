package racing_game.view;

import racing_game.model.GameResult;
import racing_game.util.Delimiter;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class ResultView {

    private static final String BLANK = "";
    private static final String EXECUTE_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_PRESENTATION = "가 최종 우승했습니다.";
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
        Map<String, String> finalRoundResult = gameResult.getGameResult().get(finalRoundNumber);
        String maxForward = finalRoundResult.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .orElseThrow();

        String winners = finalRoundResult.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue().length(), maxForward.length()))
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(Delimiter.COMMA.symbol));

        printMessage(String.format("\n%s%s", winners, WINNER_PRESENTATION));
    }
}
