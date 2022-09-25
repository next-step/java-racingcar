package racingcar;

import java.util.List;

public class ResultView {

    public static void printRacingGameLogs(List<String> racingGameLogs) {
        System.out.println("실행 결과\n" + String.join("\n\n", racingGameLogs));
    }
}
