package racing;

import racing.domain.CarGame;
import racing.domain.RandomStrategy;
import racing.domain.RoundRecord;
import racing.view.ResultView;

import java.util.List;

import static racing.view.InputView.inputGameCount;
import static racing.view.InputView.inputPalyersName;

public class Application {
    public static void main(String[] args) {
        //입력부
        String[] names = inputPalyersName();
        int rounds = inputGameCount();

        // 로직 실행부
        CarGame carGame = new CarGame(rounds, new RandomStrategy(), names);
        List<RoundRecord> roundRecords = carGame.start();
        // 출력부
        ResultView.showResult(roundRecords);
    }
}
