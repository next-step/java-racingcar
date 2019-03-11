package racing.view;


import racing.board.GameResult;
import racing.board.GameResultOfStepByStep;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ResultView {

    private static final String CHAR_TO_CONVERT = "-";

    public static void render(GameResult gameResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n실행 결과\n")
          .append(convert(
                    gameResult.stream(),
                    ResultView::convertStep,
                    "\n\n"))
          .append("\n\n")
          .append(join(
                    gameResult.winners().stream(),
                    ", "))
          .append("가 최종 우승했습니다.");

        System.out.println(sb.toString());
    }

    private static String join(Stream<String> stream, String delimiter) {
        return stream.collect(Collectors.joining(delimiter));
    }

    private static String convertStep(GameResultOfStepByStep step) {
        return convert(
                step.stream(),
                carDto -> carDto.getName() + " : " + convertPosition(carDto.getPosition()),
                "\n");
    }

    private static String convertPosition(int position) {
        return convert(
                IntStream.range(0, position).boxed(),
                i -> CHAR_TO_CONVERT,
                "");
    }

    private static <T> String convert(Stream<T> stream, Function<T, String> mapper, String delimiter) {
        return join(stream.map(mapper), delimiter);
    }

}
