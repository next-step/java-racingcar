package racingGame;

import java.util.List;

public class ResultView {
    public void printRacingResult(List<Car> gameResult) {
        TransferResult transferResult = new TransferResult(gameResult);
        System.out.println("살행결과");
        transferResult.getRoundResult();
    }


}
