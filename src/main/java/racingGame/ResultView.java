package racingGame;

import java.util.List;
import racingGame.response.GameFinalResult;
import racingGame.response.GameResult;
import racingGame.model.ProgressRecord;

public class ResultView {

    public static void printAllResult(GameFinalResult results) {
        System.out.println("실행 결과");
        List<GameResult> gameResults = results.gameResult();
        for (GameResult result : gameResults) { // 한 게임 단위
            for (ProgressRecord record : result.progressRecords()) { // 각 라운드
                for (int i = 0; i < record.carRecord().size() ; i++) {
                    System.out.print(record.carName().get(i) + " : ");
                    System.out.println(makeTrack(record.carRecord().get(i)));
                }
                System.out.println();
            }
        }
        winnersPrint(results.winners());
    }
    
    private static void winnersPrint(List<String> winners) {
        System.out.print(String.join(",", winners));
        System.out.print("가 최종 우승했습니다.");
    }
    
    static String makeTrack(int location) {
        return "-".repeat(location);
    }
}
