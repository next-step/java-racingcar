package racinggame;

import java.util.List;

public class OutputView {

    private OutputView() {}

    public static void printResult(RacingGameResult result) {
        System.out.println("실행 결과");
        System.out.println(result.getContent());

        List<String> winners = result.getWinnerNames();
        System.out.printf("%s가 최종 우승했습니다.", String.join(StringConstants.COMMA + StringConstants.SPACE, winners));
    }

}
