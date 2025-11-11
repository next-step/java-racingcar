package racingGame;

import java.util.List;
import racingGame.Response.GameResult;
import racingGame.model.ProgressRecord;

public class ResultView {

    public static void printAllResult(List<GameResult> results) {
        System.out.println("실행 결과");

        for (GameResult result : results) { // 한 게임 단위
            for (ProgressRecord record : result.progressRecords()) { // 각 라운드
                for (int location : record.carRecord()) { // 각 자동차의 위치
                    System.out.println(makeTrack(location));
                }
                System.out.println();
            }
        }
    }

    static String makeTrack(int location) {
        return "-".repeat(location);
    }
}
