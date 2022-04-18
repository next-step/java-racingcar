package step_3.view;

import step_3.model.GameResult;

import java.util.concurrent.atomic.AtomicReference;

public class ResultView {

    private static final String EXECUTE_RESULT_MESSAGE = "실행 결과";

    private ResultView() {
    }

    public static void printMessage(String dialogue) {
        System.out.println(dialogue);
    }

    public static void printResult(GameResult gameResult) {
        printMessage(EXECUTE_RESULT_MESSAGE);
        gameResult.getGameResult().forEach(result -> {
            AtomicReference<String> a = new AtomicReference<>("");
            result.forEach(r -> a.getAndAccumulate(r, (before, after) -> before += ("\n" + after)));
            printMessage(a.get());
        });
    }
}
