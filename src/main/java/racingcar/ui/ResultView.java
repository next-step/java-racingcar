package racingcar.ui;

import racingcar.common.Constants;
import racingcar.domain.RacingResult;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ResultView {

    public static void print(RacingResult racingResult) {
        List<Map<String, Integer>> movingHistoryByTry = racingResult.getMovingHistoryByTry();
        List<String> winners = racingResult.getWinners();

        System.out.println(Constants.PRINT_RESULT);
        movingHistoryByTry.forEach(
            map -> {
                map.forEach( (k,v) -> drawMovingHistory(k,v));
                System.out.print(Constants.NEW_LINE_DELIMITER);
            }
        );

        System.out.print(String.join(Constants.COMMA_DELIMITER, winners));
        System.out.print(Constants.THE_WINNER_IS);
    }

    private static void drawMovingHistory(String k, Integer v) {
        System.out.println(k.concat(Constants.WHITE_SPACE_DELIMITER)
                .concat(Constants.COLON_DELIMITER)
                .concat(Constants.WHITE_SPACE_DELIMITER)
                .concat(String.join(Constants.BLANK_DELIMITER, Collections.nCopies(v, Constants.HYPHEN_DELIMITER)))
        );
    }
}
