package racingcar.view;

import static racingcar.utils.PrintUtils.print;

import java.util.stream.Collectors;
import racingcar.dto.GameResult;

public class ResultView {

    public static final String RESULT_INIT_MESSAGE = "실행 결과";
    public static final String CAR_DELIMITER = "\r\n";
    public static final String ROUND_DELIMITER = "\r\n\r\n";

    public ResultView() {
        print(RESULT_INIT_MESSAGE);
    }

    public void show(GameResult result) {
        print(convertToPrintValue(result));
    }

    private String convertToPrintValue(GameResult result) {
        return result.getProgress().stream()
            .map(roundProgress -> String.join(CAR_DELIMITER, roundProgress.results()))
            .collect(Collectors.joining(ROUND_DELIMITER));
    }
}
