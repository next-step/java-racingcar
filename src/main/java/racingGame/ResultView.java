package racingGame;

import java.util.ArrayList;
import java.util.List;
import racingGame.model.Car;
import racingGame.response.GameFinalResult;
import racingGame.response.GameResult;
import racingGame.model.ProgressRecord;

public class ResultView {

    public static void printAllResult(GameFinalResult results) {
        System.out.println("실행 결과");
        List<GameResult> gameResults = results.gameResult();
        for (GameResult result : gameResults) { // 한 게임 단위
            for (ProgressRecord record : result.progressRecords()) { // 각 라운드
                for (int i = 0; i < record.joinCars().size() ; i++) {
                    System.out.print(record.joinCars().get(i).getName() + " : ");
                    System.out.println(makeTrack(record.joinCars().get(i).findLocation()));
                }
                System.out.println();
            }
        }
        winnersPrint(results.winners());
    }
    
    private static void winnersPrint(List<Car> winners) {
        List<String> carsName = new ArrayList<>();
        for(Car winner: winners) {
            carsName.add(winner.getName());
        }
        System.out.print(String.join(",", carsName));
        System.out.print("가 최종 우승했습니다.");
    }
    
    static String makeTrack(int location) {
        return "-".repeat(location);
    }
}
